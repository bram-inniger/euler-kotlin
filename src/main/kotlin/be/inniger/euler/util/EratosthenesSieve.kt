package be.inniger.euler.util

/**
 * Classic implementation of the Sieve of Eratosthenes.
 * More info: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */
class EratosthenesSieve(size: Int) {
    private val sieve = if (size < 2) throw IllegalArgumentException("Size $size contains no primes! ")
    else BooleanArray(size + 1)
        .apply { fill(true) }
        .apply { this[0] = false }
        .apply { this[1] = false }
        .apply {
            (2..roundedSqrt(size)).asSequence()
                .filter { this[it] }
                .flatMap { ((it * it)..lastIndex step it).asSequence() }
                .forEach { this[it] = false }
        }

    /**
     * Check if a number contained in this sieve is prime or not.
     */
    fun isPrime(number: Int) = if (number >= 0 && number <= sieve.lastIndex) sieve[number]
    else throw IllegalArgumentException("Number $number does not fit in the sieve with size ${sieve.size}")

    /**
     * Get all the primes contained in this sieve.
     */
    fun getPrimes() = (0..sieve.lastIndex).filter { sieve[it] }
}
