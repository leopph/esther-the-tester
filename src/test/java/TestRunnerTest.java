import esther.TestRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRunnerTest {
    @Test
    void doesRunBeforeClass() {
        MyTestResults.beforeClassRan = false;
        new TestRunner(MyTestClass.class).doTest();
        assertTrue(MyTestResults.beforeClassRan);
    }

    @Test
    void doesRunBeforeTest() {
        MyTestResults.beforeTestRan = false;
        new TestRunner(MyTestClass.class).doTest();
        assertTrue(MyTestResults.beforeTestRan);
    }

    @Test
    void doesPass() {
        MyTestResults.passingTestSuccess = false;
        new TestRunner(MyTestClass.class).doTest();
        assertTrue(MyTestResults.passingTestSuccess);
    }

    @Test
    void doesFail() {
        MyTestResults.failingTestSucceeded = false;
        new TestRunner(MyTestClass.class).doTest();
        assertFalse(MyTestResults.failingTestSucceeded);
    }

    @Test
    void doesSkip() {
        MyTestResults.skippedTestRan = false;
        new TestRunner(MyTestClass.class).doTest();
        assertFalse(MyTestResults.skippedTestRan);
    }

    @Test
    void doesRunAfterTest() {
        MyTestResults.afterTestRan = false;
        new TestRunner(MyTestClass.class).doTest();
        assertTrue(MyTestResults.afterTestRan);
    }

    @Test
    void doesRunAfterClass() {
        MyTestResults.afterClassRan = false;
        new TestRunner(MyTestClass.class).doTest();
        assertTrue(MyTestResults.afterClassRan);
    }
}
