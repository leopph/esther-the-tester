import esther.*;

import static esther.AssertionsKt.assertTrue;

@TestCase
public class MyPassingTestClass {
    public static boolean beforeClassRan = false;
    public boolean beforeRan = false;
    public boolean passingTestSuccess = false;
    public boolean skippedTestRan = true;
    public boolean afterRan = false;
    public static boolean afterClassRan = false;

    @BeforeClass
    public static void beforeClass() {
        beforeClassRan = true;
    }

    @Before
    public void before() {
        beforeRan = true;
    }

    @Test
    public void passingTest() {
        assertTrue(true);
        passingTestSuccess = true;
    }

    @Test @Skip
    public void skippedTest() {
        assert(true);
        skippedTestRan = true;
    }

    @After
    public void after() {
        afterRan = true;
    }

    @AfterClass
    public static void afterClass() {
        afterClassRan = true;
    }
}
