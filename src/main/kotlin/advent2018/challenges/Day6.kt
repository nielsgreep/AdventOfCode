package advent2018.challenges

import java.lang.Math.abs

class Day6(inputList: List<String>) {

    private val input: List<String> = inputList

    private val coordinates: List<Coordinate> = input.map { toCoordinate(it) }
    private val lowestX = coordinates.map { it.x }.min()
    private val highestX = coordinates.map { it.x }.max()
    private val lowestY = coordinates.map { it.y }.min()
    private val highestY = coordinates.map { it.y }.max()

    private val grid = createGrid(lowestX, highestX, lowestY, highestY)

    private var listOfInfinite = mutableListOf<Coordinate>()

    class Coordinate(val x: Int, val y: Int) {

        fun isClosestTo(list: List<Coordinate>): Map.Entry<Int, List<Coordinate>>? {

            var result = list.groupBy { this.distance(it) }.minBy { it.key }

            return result

        }


        fun distance(other: Coordinate) = abs(x - other.x) + abs(y - other.y)
        fun listOfDistances(list: List<Coordinate>): List<Int> {

            return list.map { it.distance(this) }

        }
    }

    private fun toCoordinate(line: String): Coordinate {
        val (x, y) = line.split(",").map {it.trim()}
        return Coordinate(x.toInt(), y.toInt())

    }



    fun isOnTheEdge(point: Coordinate): Boolean {

        return point.x == highestX || point.x == lowestX || point.y == highestY || point.y == lowestY
    }

    fun isInfinite(point: Coordinate): Boolean {

        return listOfInfinite.contains(point)

    }


    private fun createGrid(xLow: Int?, xHi: Int?, yLow: Int?, yHi: Int?): List<Coordinate> {
        var gridCoordinates = mutableListOf<Coordinate>()

        for (x in xLow!!..xHi!!) {
            for (y in yLow!!..yHi!!) {
                gridCoordinates.add(Coordinate(x, y))
            }
        }

        return gridCoordinates

    }

    fun part1(): Int {
        val result = grid.map {
            gridC -> gridC.isClosestTo(coordinates).takeIf { it!!.value.size < 2 } }.zip(other = grid)

        for (i in result) {
            if (isOnTheEdge(i.second) && i.first != null) listOfInfinite.add(i.first!!.value.first())
        }

        val result2 = result.filter { it.first != null && !isInfinite(it.first!!.value.first()) }.groupBy { it.first!!.value.first() }.maxBy { it.value.size }!!.value.size

        return result2


    }

    fun part2(): Int {

        val result = grid.map { it.listOfDistances(coordinates) }.zip(grid).filter { it.first.sum() < 10000 }

        return result.size

    }

}