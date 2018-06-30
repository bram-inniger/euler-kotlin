package util

import org.junit.Test
import kotlin.test.assertEquals

class MathTest {

    @Test
    fun `Can calculate the power of a positive integer base with a positive integer exponent`() {
        assertEquals(0, pow(0, 1))
        assertEquals(0, pow(0, 2))
        assertEquals(1, pow(1, 0))
        assertEquals(1, pow(1, 1))
        assertEquals(1, pow(1, 2))
        assertEquals(1, pow(2, 0))
        assertEquals(2, pow(2, 1))
        assertEquals(4, pow(2, 2))
        assertEquals(8, pow(2, 3))
    }

    @Test
    fun `Can calculate the power of a negative integer base with a positive integer exponent`() {
        assertEquals(-2, pow(-2, 1))
        assertEquals(4, pow(-2, 2))
        assertEquals(-8, pow(-2, 3))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Throws on the undefined case where both base and exponent are zero`() {
        pow(0, 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Throws on the invalid case where the exponent is negative, as the result cannot be represented by an integer`() {
        pow(2, -1)
    }
}
