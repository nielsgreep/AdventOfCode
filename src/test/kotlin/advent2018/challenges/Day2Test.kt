package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day2Test {

    private val input = File("src/main/resources/advent2018/day2.txt").readLines()
    private var day2 = Day2(input.toMutableList())

    @Test
    fun part1Test() {
        print(day2.part1())
    }

    @Test
    fun part2Test() {
        print(day2.part2())
    }
}

