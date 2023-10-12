@TestCase
public class MyTestClass {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void test() {
        System.out.println("test");
    }

    @Test @Skip
    public void skippedTest() {
        System.out.println("skipped test");
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
