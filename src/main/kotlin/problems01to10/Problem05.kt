package problems01to10

private const val MAX_VALUE = 20

/**
 * Smallest multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
fun solve05() = generateSequence(1, Int::inc)
    .filter { divisor -> IntRange(1, MAX_VALUE).none { divisor % it != 0 } }
    .first()
