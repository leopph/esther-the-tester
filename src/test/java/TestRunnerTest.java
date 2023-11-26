import esther.TestRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRunnerTest {
    @Test
    void doesPass() {
        new TestRunner(MyPassingTestClass.class).doTest();
    }

    @Test
    void doesFail() {
        new TestRunner(MyFailingTestClass.class).doTest();
    }
}
