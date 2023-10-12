@TestCase
public class MyPassingTestClass {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public boolean passingTest() {
        System.out.println("passing test");
        return true;
    }

    @Test @Skip
    public boolean skippedTest() {
        System.out.println("skipped test");
        return true;
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }
}
