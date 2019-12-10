package advent2019.challenges

import advent2019.Utils.readInputOfDayAsStringList

fun main() {

    println(part1Day6())
    println(part2Day6())
}

private val orbitPairs: Map<String, String> = readInputOfDayAsStringList(6).map { it.split(")") }.map { it.last() to it.first() }.toMap()

fun part1Day6(): Int =
        orbitPairs.keys.sumBy { pathTo(it).size -1 }

fun part2Day6(): Int {
    val youToRoot = pathTo("YOU")
    val santaToRoot = pathTo("SAN")
    val intersection = youToRoot.intersect(santaToRoot).first()

    return youToRoot.indexOf(intersection) + santaToRoot.indexOf(intersection) - 2
}

private fun pathTo(orbit: String, path: MutableList<String> = mutableListOf(orbit)): List<String> =
        orbitPairs[orbit]?.let { around ->
            path.add(around)
            pathTo(around, path)
        } ?: path
