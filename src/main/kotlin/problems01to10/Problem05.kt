package problems01to10

import util.EratosthenesSieve
import util.pow

private const val MAX_VALUE = 20

/**
 * Smallest multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
fun solve05() = (1..MAX_VALUE) // Iterate over all numbers from 1 to 20
    .flatMap { number ->
        primes.map { prime -> Factor(prime, getFrequency(number, prime)) } // Decompose every number into its Factors
            .filter { factor -> factor.frequency > 0 } // Remove all the Factors that never occur (frequency = 0)
    }
    .groupingBy { it.prime } // Group all these Factors by prime
    .reduce { _, acc, factor ->
        maxOf(acc, factor, compareBy(Factor::frequency))
    } // Per prime pick the factor with the highest frequency
    .map { it.value } // Map the Map.Entry<Int, Factor> back onto Factor
    .map { pow(it.prime, it.frequency) } // Get the power of each prime factor back with its frequency
    .reduce { acc, factor -> factor * acc } // Make the product of all these powers to get the smallest number evenly divisible by all numbers

private val primes
    get() = EratosthenesSieve(MAX_VALUE).getPrimes() // Pre-calculate all potential prime factors up until 20

/**
 * Calculate how many times a given prime "fits" in a number.
 * Start by checking if it fits once, twice, thrice, ...
 * The first time "nr times it fits + 1" does not fit any more, then the answer is found!
 */
private fun getFrequency(number: Int, prime: Int) = generateSequence(1, Int::inc)
    .first { number % pow(prime, it + 1) != 0 }

/**
 * Store which prime occurred how many times in a number.
 */
private data class Factor(val prime: Int, val frequency: Int)
