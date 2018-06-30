package problems01to10

import util.EratosthenesSieve
import kotlin.math.ln
import kotlin.math.roundToInt

// -1 as the problem specification is 1-indexed but Kotlin's collections are 0-indexed
private const val PRIME_INDEX = 10_001 - 1

/**
 * 10001st prime
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
fun solve07() = EratosthenesSieve(calculateSieveSize()).getPrimes()[PRIME_INDEX]

/**
 * Calculate a reasonable upper bound to use as sieve size, in a way that the sieve will contain the 10_001th prime.
 * The code below very roughly calculates the inverse of a Prime-counting function.
 * Details here: https://en.wikipedia.org/wiki/Prime-counting_function
 *
 * The approximate function to count primes "pi(N) = N / ln(N)" is reversed by trying exponentially larger N values,
 * until "pi(N)" evaluates to something larger than 10_001.
 * This way we know that calculating the sieve up until N should contain the 10_001th prime.
 *
 * When running the program for the 10_001th prime we find the following values:
 * * Prime nr. 10_001 = 104743
 * * Upper sieve size = 125278
 * Showing that indeed the upper bound is reasonably guessed!
 */
private fun calculateSieveSize() = generateSequence(10.0) { i -> i * 1.1 }
    .first { it / ln(it) > PRIME_INDEX }
    .roundToInt()
