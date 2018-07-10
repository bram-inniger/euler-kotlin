package problems11to20

private const val NR_ADJACENT = 4

/**
 * Largest product in a grid
 *
 * In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
 * What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
 */
fun solve11() =
    if (doesGridFailValidation()) throw IllegalArgumentException("Grid needs to be rectangular!") // Verify if the grid is indeed a grid
    else grid.indices // 0 until 20, y-coordinate
        .flatMap { y ->
            grid[0].indices // 0 until 20, x-coordinate
                .map { x -> Coordinate(x, y) } // Put x and y together in a coordinate
        } // This is now a List<Coordinate> containing all possible grid positions
        .flatMap { coordinate ->
            Direction.values() // Per coordinate, look in all (de-duplicated) directions (e.g. if you look down you don't need to look up)
                .map { direction ->
                    Line(coordinate, direction)
                } // Draw a line from a coordinate in a directions (line = 4 adjacent numbers)
        } // This is now a List<Line> containing all possible lines that can be drawn from all possible grid positions
        .filter(Line::isValid) // Only keep lines that fit inside the grid (e.g. if the origin is on the final row it does not make sense to have a line downwards)
        .map(Line::product) // Of all valid lines calculate the product of the adjacent numbers
        .max()!! // Get the greatest product

private val grid
    get() = Thread.currentThread().contextClassLoader.getResourceAsStream("Problem11.txt")
        .reader()
        .readLines() // Results in List<String>, 1 String per line in the file
        .filter(String::isNotBlank) // Ignore blank lines
        .map { it.split(" ") } // Results in List<List<String>>, split every line in its separate String values
        .map { it.map(String::toInt) } // Results in List<List<Int>>, the grid, by converting every single String into an Int

private fun doesGridFailValidation() = grid
    .map { it.size } // For the grid to be a rectangle, every row needs to have the same length
    .distinct() // Get all the different row lengths in the grid
    .count() != 1 // If there is more than 1 different length, the grid is not rectangular, and thus not a valid grid

private enum class Direction(internal val deltaX: Int, internal val deltaY: Int) {
    DOWNWARD(0, 1),
    RIGHTWARD(1, 0),
    UP_RIGHT(1, -1),
    DOWN_RIGHT(1, 1)
}

private data class Coordinate(internal val x: Int, internal val y: Int)

private data class Line(private val origin: Coordinate, private val direction: Direction) {

    // Start from the coordinate, and walk in a Direction, to get 4 adjacent coordinates
    private val line
        get() = (0 until NR_ADJACENT).map {
            Coordinate(
                origin.x + it * direction.deltaX,
                origin.y + it * direction.deltaY
            )
        }

    // A line will be inside the rectangle if both ends of the line are inside
    internal val isValid
        get() = line.first().x in 0..grid[0].lastIndex &&
                line.first().y in 0..grid.lastIndex &&
                line.last().x in 0..grid[0].lastIndex &&
                line.last().y in 0..grid.lastIndex

    // Calculate the product of the 4 adjacent numbers on the line
    internal val product
        get() = line.map { grid[it.y][it.x] }
            .reduce { acc, factor -> acc * factor }
}
