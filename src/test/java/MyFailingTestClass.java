public class MyFailingTestClass {
    @Test
    public boolean failingTest() {
        System.out.println("failing test");
        return false;
    }
}
