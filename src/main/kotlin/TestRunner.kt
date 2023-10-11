import java.lang.reflect.Modifier

class TestRunner(private val clazz: Class<*>) {
    fun doTest(): Boolean {
        if (TestCase() !in clazz.annotations) {
            return false
        }

        val beforeClassMethods = clazz.methods.filter {
            Modifier.isStatic(it.modifiers) && BeforeClass() in it.annotations
        }

        val afterClassMethods = clazz.methods.filter {
            Modifier.isStatic(it.modifiers) && AfterClass() in it.annotations
        }

        val beforeTestMethods = clazz.methods.filter {
            !Modifier.isStatic(it.modifiers) && Before() in it.annotations
        }

        val afterTestMethods = clazz.methods.filter {
            !Modifier.isStatic(it.modifiers) && After() in it.annotations
        }

        val testMethods = clazz.methods.filter {
            !Modifier.isStatic(it.modifiers) && Test() in it.annotations && Skip() !in it.annotations
        }

        for (beforeClassMethod in beforeClassMethods) {
            beforeClassMethod.invoke(null)
        }

        for (testMethod in testMethods) {
            val instance = clazz.getConstructor().newInstance()

            for (beforeTestMethod in beforeTestMethods) {
                beforeTestMethod.invoke(instance)
            }

            testMethod.invoke(instance)

            for (afterTestMethod in afterTestMethods) {
                afterTestMethod.invoke(instance)
            }
        }

        for (afterClassMethod in afterClassMethods) {
            afterClassMethod.invoke(null)
        }

        return true
    }
}