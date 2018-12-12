package advent2018.challenges

class Day11 {

    val input = 7400

    private val grid = (1..300)
            .map { x -> (1..300).map { y -> calculatePowerLevel(x, y) } }

    fun part1() {

        var totalMaxPower = 0
        var xCoordinate = 0
        var yCoordinate = 0

        for (x in 1..298) {
            for (y in 1..298) {
                if (grid.calculatePowerOfField(x - 1, y - 1, 2) > totalMaxPower) {
                    totalMaxPower = grid.calculatePowerOfField(x - 1, y - 1, 2)
                    xCoordinate = x
                    yCoordinate = y
                }
            }
        }

        println("$xCoordinate,$yCoordinate")

    }

    private fun calculatePowerLevel(x: Int, y: Int): Int {
        var powerLevel = 0

        var rackId = x + 10
        powerLevel = (rackId * y + input) * rackId / 100 % 10 - 5

        return powerLevel
    }

    fun part2() {
        var totalMaxPower = 0
        var xCoordinate = 0
        var yCoordinate = 0
        var size = 0

        for (maxSize in 1..300) {

            for (x in 1..299 - maxSize) {
                for (y in 1..299 - maxSize) {
                    if (grid.calculatePowerOfField(x, y, maxSize) > totalMaxPower) {
                        totalMaxPower = grid.calculatePowerOfField(x, y, maxSize)
                        xCoordinate = x + 1
                        yCoordinate = y + 1
                        size = maxSize + 1

                    }

                }
            }
        }

        println("$xCoordinate,$yCoordinate,$size")


    }

    private fun List<List<Int>>.calculatePowerOfField(x: Int, y: Int, maxSize: Int): Int {
        var totalPower = 0

        for (x in x..x+maxSize) {
            for (y in y..y+maxSize) {
                totalPower += this[x][y]
            }
        }
        return totalPower

    }

}