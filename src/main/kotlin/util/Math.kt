package util

import java.lang.StrictMath.multiplyExact
import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * Calculate the power of an integer base with a positive integer exponent, throwing on invalid inputs.
 */
fun pow(base: Int, exponent: Int) = when {
    base == 0 && exponent == 0 -> throw IllegalArgumentException("Base and exponent cannot both be 0, this is undefined")
    exponent < 0 -> throw IllegalArgumentException("Negative exponents lead to results that cannot be assigned to Int")
    else -> (1..exponent).fold(1) { acc, _ -> multiplyExact(acc, base) }
}

fun roundedSqrt(number: Number) = sqrt(number.toDouble())
    .roundToInt()
