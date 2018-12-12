package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day3Test {


    private val input = File("src/main/resources/advent2018/day3.txt").readLines()
    private var day3 = Day3(input.toMutableList())

    @Test
    fun part1Test() {
        print(day3.part1())
    }

    @Test
    fun part2Test() {
        print(day3.part2())
    }
}