package esther

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Modifier

class TestRunner(private val clazz: Class<*>) {
    fun doTest() {
        if (TestCase() !in clazz.annotations) {
            return
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

        val skippedCount = clazz.methods.count {
            !Modifier.isStatic(it.modifiers) && Test() in it.annotations && Skip() in it.annotations
        }

        var successCount = 0
        var failCount = 0

        println("Running ${testMethods.size} test(s).")

        for (beforeClassMethod in beforeClassMethods) {
            beforeClassMethod.invoke(null)
        }

        for (testMethod in testMethods) {
            val instance = clazz.getConstructor().newInstance()

            for (beforeTestMethod in beforeTestMethods) {
                beforeTestMethod.invoke(instance)
            }

            try {
                print("Test ${testMethod.name}... ")
                testMethod.invoke(instance)
                successCount += 1
                print("ok")
            } catch (e: InvocationTargetException) {
                if (e.targetException !is EstherAssertionFailed) {
                    throw e
                }

                failCount += 1
                print("failed")
            }

            println(".")

            for (afterTestMethod in afterTestMethods) {
                afterTestMethod.invoke(instance)
            }
        }

        for (afterClassMethod in afterClassMethods) {
            afterClassMethod.invoke(null)
        }

        println("Tests finished: $successCount ok, $failCount failed, $skippedCount skipped.")
    }
}