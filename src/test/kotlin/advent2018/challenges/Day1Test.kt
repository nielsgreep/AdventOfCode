package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day1Test {

    private val input = File("src/main/resources/advent2018/day1.txt").readLines()
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