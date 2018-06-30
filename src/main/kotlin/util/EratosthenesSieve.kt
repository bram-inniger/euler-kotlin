package util

import kotlin.math.sqrt

/**
 * Classic implementation of the Sieve of Eratosthenes.
 * More info: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */
class EratosthenesSieve(size: Int) {
    private val sieve = if (size > 0) calculateSieve(size)
    else throw IllegalArgumentException("Size cannot be smaller than one, but was $size")

    private fun calculateSieve(size: Int): BooleanArray {
        val sieve = BooleanArray(size + 1).apply { fill(true) }
        sieve[0] = false
        sieve[1] = false

        for (i in 2..sqrt(size.toDouble()).toInt()) {
            if (sieve[i]) {
                for (j in (i * i)..sieve.lastIndex step i) {
                    sieve[j] = false
                }
            }
        }

        return sieve
    }

    /**
     * Check if a number contained in this sieve is prime or not.
     */
    fun isPrime(number: Int) = if (number >= 0 && number <= sieve.lastIndex) sieve[number]
    else throw IllegalArgumentException("Number $number does not fit in the sieve with size ${sieve.size}")

    /**
     * Get all the primes contained in this sieve.
     */
    fun getPrimes() = IntRange(0, sieve.lastIndex)
        .filter { sieve[it] }
}
