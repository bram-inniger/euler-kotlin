package problems01to10

import util.isPalindrome

private const val BIGGEST_N_DIGIT_NUMBER = 999
private const val SMALLEST_N_DIGIT_NUMBER = 100

/**
 * Largest palindrome product
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
fun solve04() = (SMALLEST_N_DIGIT_NUMBER..BIGGEST_N_DIGIT_NUMBER)
    .flatMap { i ->
        (SMALLEST_N_DIGIT_NUMBER..i).map { j -> i to j }
    }
    .map { it.first * it.second }
    .filter { isPalindrome(it.toString().toList()) }
    .max()!!
