package be.inniger.euler.problems01to10

private const val MAX_VALUE = 4_000_000

/**
 * Even Fibonacci numbers
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
fun solve02() = fib(1, 0, 0)

private tailrec fun fib(prev: Int, prevPrev: Int, evenSum: Int): Int =
    if (prev > MAX_VALUE) evenSum
    else {
        val current = prev + prevPrev
        fib(prev = current, prevPrev = prev, evenSum = evenSum + if (current % 2 == 0) current else 0)
    }
