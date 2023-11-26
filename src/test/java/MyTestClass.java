import esther.*;

import static esther.AssertionsKt.assertTrue;

@TestCase
public class MyTestClass {
    @BeforeClass
    public static void beforeClass() {
        MyTestResults.beforeClassRan = true;
    }

    @Before
    public void before() {
        MyTestResults.beforeTestRan = true;
    }

    @Test
    public void passingTest() {
        assertTrue(true);
        MyTestResults.passingTestSuccess = true;
    }

    @Test
    public void failingTest() {
        assertTrue(false);
        MyTestResults.failingTestSucceeded = true;
    }

    @Test @Skip
    public void skippedTest() {
        assert(true);
        MyTestResults.skippedTestRan = true;
    }

    @After
    public void after() {
        MyTestResults.afterTestRan = true;
    }

    @AfterClass
    public static void afterClass() {
        MyTestResults.afterClassRan = true;
    }
}
