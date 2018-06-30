package util

import org.junit.Test
import kotlin.test.assertEquals

class EratosthenesSieveTest {

    @Test
    fun `Can detect primes`() {
        val sieve = EratosthenesSieve(42)

        assertEquals(true, sieve.isPrime(5))
        assertEquals(true, sieve.isPrime(7))
        assertEquals(true, sieve.isPrime(13))
        assertEquals(true, sieve.isPrime(29))
    }

    @Test
    fun `Can detect not primes`() {
        val sieve = EratosthenesSieve(42)

        assertEquals(false, sieve.isPrime(0))
        assertEquals(false, sieve.isPrime(1))
        assertEquals(false, sieve.isPrime(4))
        assertEquals(false, sieve.isPrime(42))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Throws on negative sieve size`() {
        EratosthenesSieve(-1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Throws on positive out of bounds prime index`() {
        EratosthenesSieve(42).isPrime(43)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Throws on negative out of bounds prime index`() {
        EratosthenesSieve(42).isPrime(-1)
    }

    @Test
    fun `Can get primes`() {
        assertEquals(listOf(2, 3, 5), EratosthenesSieve(5).getPrimes())
        assertEquals(listOf(2, 3, 5, 7, 11, 13, 17, 19), EratosthenesSieve(19).getPrimes())
    }
}
