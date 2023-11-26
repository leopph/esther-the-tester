import esther.Test;
import esther.TestCase;

import static esther.AssertionsKt.assertTrue;

@TestCase
public class MyFailingTestClass {
    public boolean testSuccess = false;

    @Test
    public void failingTest() {
        assertTrue(false);
        testSuccess = true;
    }
}
