package esther

fun assertTrue(value: Boolean) {
    if (!value) {
        throw EstherAssertionFailed()
    }
}