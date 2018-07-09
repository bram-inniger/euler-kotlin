package problems01to10

import util.EratosthenesSieve
import util.roundedSqrt

private const val NUMBER = 600851475143L

/**
 * Largest prime factor
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
fun solve03() = EratosthenesSieve(roundedSqrt(NUMBER)).getPrimes()
    .last { NUMBER % it == 0L }
