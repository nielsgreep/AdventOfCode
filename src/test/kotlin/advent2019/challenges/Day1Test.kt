package advent2019.challenges

import advent2019.Utils.readInputOfDayAsStringList
import org.junit.Test

internal class Day1Test {

    private val input = readInputOfDayAsStringList(1)
    private var day1 = Day1(input)

    @Test
    fun part1Test() {
        print(day1.part1())
    }

    @Test
    fun part2Test() {
        print(day1.part2())
    }
}