package problems01to10

import java.lang.Character.getNumericValue
import java.lang.Character.isDigit

private const val NR_ADJACENT_DIGITS = 13

/**
 * Largest product in a series
 *
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 */
fun solve08() = (0 until number.size - NR_ADJACENT_DIGITS)
    .map { number.subList(it, it + NR_ADJACENT_DIGITS) }
    .map { digits ->
        digits.map(Int::toLong)
            .reduce { acc, digit -> acc * digit }
    }
    .max()!!

private val number = Thread.currentThread().contextClassLoader.getResourceAsStream("Problem08.txt")
    .reader()
    .readText()
    .filter(::isDigit)
    .map(::getNumericValue)
