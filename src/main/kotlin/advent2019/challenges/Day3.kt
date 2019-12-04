package advent2019.challenges

import advent2019.Utils.readInputOfDayAsStringList
import kotlin.math.abs

val input = readInputOfDayAsStringList(3)
private val wire1 = input[0].split(",").map { Instruction(it.first(), it.drop(1).toInt()) }
private val wire2 = input[1].split(",").map { Instruction(it.first(), it.drop(1).toInt()) }
val intersections = parseWire(wire1).intersect(parseWire(wire2))

fun main() {

    println(part1())
    println(part2())
}

fun part1(): Int {

    return intersections.map { manhattanDistanceFromZero(it) }.min()!!

}

fun part2(): Int {

    return intersections.map { point -> parseWire(wire1).indexOf(point) + 1 + parseWire(wire2).indexOf(point) + 1 }.min()!!

}


private fun parseWire(instructions: List<Instruction>): List<Pair<Int, Int>> {

    var startingPoint = Pair(0,0)
    return instructions.flatMap {
        val direction = it.direction
        val length = it.length
        (0 until length).map {
            val nextPoint = when(direction) {
                'U' -> Pair(startingPoint.first, startingPoint.second + 1)
                'D' -> Pair(startingPoint.first, startingPoint.second - 1)
                'L' -> Pair(startingPoint.first - 1, startingPoint.second)
                'R' -> Pair(startingPoint.first + 1, startingPoint.second)
                else -> throw Exception("")
            }
            startingPoint = nextPoint
            nextPoint
        }

    }

}

private fun manhattanDistanceFromZero(point: Pair<Int, Int>): Int {
    return abs(point.first) + abs(point.second)
}

private class Instruction(val direction: Char, val length: Int)

