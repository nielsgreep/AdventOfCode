package advent2018.challenges

class Day10(inputList: List<String>) {

    private var coordinateList: List<Coordinate> = inputList
            .map { it.extractInts() }
            .map { numbers -> Coordinate(numbers[0].toLong(), numbers[1].toLong(), numbers[2].toLong(), numbers[3].toLong()) }

    class Coordinate(val x: Long, val y: Long, val xVelo: Long, val yVelo: Long) {
        fun iterate(): Coordinate {
            return Coordinate(x + xVelo, y + yVelo, xVelo, yVelo)
        }

        fun iterateBack(): Coordinate {
            return Coordinate(x - xVelo, y - yVelo, xVelo, yVelo)
        }

    }

    fun List<Coordinate>.drawGrid() {
        val minX = minBy { it.x }!!.x
        val maxX = maxBy { it.x }!!.x
        val minY = minBy { it.y }!!.y
        val maxY = maxBy { it.y }!!.y

        val builder = StringBuilder()

        println()


        for (y in minY..maxY) {
            for (x in minX..maxX) {
                if (this.any { it.x == x && it.y == y }) {
                    builder.append("#")
                }
                else
                    builder.append(" ")
            }
            builder.append("\n")
        }

        println(builder)

    }



    fun part1(): List<Coordinate> {

        var distance = Long.MAX_VALUE
        var counter = 0

        while (true) {

            val maxY = coordinateList.maxBy { it.y }!!.y
            val maxX = coordinateList.maxBy { it.x }!!.x
            val minY = coordinateList.minBy { it.y }!!.y
            val minX = coordinateList.minBy { it.x }!!.x

            if ((maxY - minY) * (maxX - minX)> distance) {
                coordinateList = coordinateList.map { it.iterateBack() }
                counter--
                coordinateList.drawGrid()
                break
            }

            distance = (maxY - minY) * (maxX - minX)
            coordinateList = coordinateList.map { it.iterate() }
            counter++
        }


        return coordinateList
    }

    fun part2(): Int {

        var distance = Long.MAX_VALUE
        var counter = 0

        while (true) {

            val maxY = coordinateList.maxBy { it.y }!!.y
            val maxX = coordinateList.maxBy { it.x }!!.x
            val minY = coordinateList.minBy { it.y }!!.y
            val minX = coordinateList.minBy { it.x }!!.x

            if ((maxY - minY) * (maxX - minX)> distance) {
                coordinateList = coordinateList.map { it.iterateBack() }
                counter--
                coordinateList.drawGrid()
                break
            }

            distance = (maxY - minY) * (maxX - minX)
            coordinateList = coordinateList.map { it.iterate() }
            counter++
        }


        return counter
    }

}