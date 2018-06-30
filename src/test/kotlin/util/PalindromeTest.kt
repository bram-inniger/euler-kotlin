package util

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PalindromeTest {

    @Test
    fun `Empty and single element lists are palindrome`() {
        assertTrue(isPalindrome(emptyList()))
        assertTrue(isPalindrome(listOf(42)))
        assertTrue(isPalindrome(listOf('a')))
        assertTrue(isPalindrome(listOf("b")))
    }

    @Test
    fun `Can detect palindrome lists`() {
        assertTrue(isPalindrome(listOf("a", "a")))
        assertTrue(isPalindrome(listOf("a", "b", "a")))
        assertTrue(isPalindrome(listOf("a", "b", "b", "a")))
        assertTrue(isPalindrome(listOf(42, 1, 42)))
        assertTrue(isPalindrome(listOf('c', 'd', 'e', 'd', 'c')))
        assertTrue(isPalindrome(listOf("b", "b", "b", "b")))
    }

    @Test
    fun `Can detect not palindrome lists`() {
        assertFalse(isPalindrome(listOf("a", "b")))
        assertFalse(isPalindrome(listOf("a", "a", "b")))
        assertFalse(isPalindrome(listOf("a", "b", "a", "b")))
        assertFalse(isPalindrome(listOf(42, 1, 41)))
        assertFalse(isPalindrome(listOf('c', 'e', 'd', 'd', 'c')))
        assertFalse(isPalindrome(listOf("b", "b", "b", "a")))
    }
}
