import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRunnerTest {

    @Test
    void test() {
        assertTrue(new TestRunner(MyTestClass.class).doTest());
    }
}
