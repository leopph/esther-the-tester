import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestRunnerTest {
    @Test
    void doesPass() {
        assertTrue(new TestRunner(MyPassingTestClass.class).doTest());
    }

    @Test
    void doesFail() {
        assertFalse(new TestRunner(MyFailingTestClass.class).doTest());
    }
}
