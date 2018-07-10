package problems01to10

import util.EratosthenesSieve
import java.math.BigDecimal

private const val MAX_VALUE = 2_000_000

/**
 * Summation of primes
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
fun solve10() = EratosthenesSieve(MAX_VALUE).getPrimes()
    .map(::BigDecimal)
    .fold(BigDecimal.ZERO, BigDecimal::add)
    .longValueExact()
