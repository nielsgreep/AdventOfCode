package advent2019.challenges

import kotlin.math.max


class Day1(inputList: List<String>) {

    private val intList: List<Int> = inputList.map { it.toInt()}

    fun part1(): Int {

        return intList.map { calcFuel(it) }.sum()
    }

    fun part2(): Int {

        return intList.map { totalFuel(it) }.sum()
    }



    private fun calcFuel(x: Int): Int {

        return max((x / 3) - 2, 0)
    }

    private fun totalFuel(x: Int): Int {
        var fuel = calcFuel(x)
        var totalFuel = fuel
        while (fuel != 0){
            fuel = calcFuel(fuel)
            totalFuel += fuel
        }
        return totalFuel
    }

}