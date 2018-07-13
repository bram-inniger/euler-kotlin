package problems01to10

private const val TRIPLET_SUM = 1000

/**
 * Special Pythagorean triplet
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
fun solve09() = (1..TRIPLET_SUM)
    .flatMap { a ->
        (1..TRIPLET_SUM).map { b -> PythagoreanTriplet(a, b, TRIPLET_SUM - a - b) }
    }
    .first(PythagoreanTriplet::valid)
    .prod

private data class PythagoreanTriplet(val a: Int, val b: Int, val c: Int) {

    internal val valid = a > 0 &&
            b > 0 &&
            c > 0 &&
            a * a + b * b == c * c

    internal val prod = a * b * c
}
