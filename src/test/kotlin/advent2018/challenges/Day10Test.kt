package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day10Test {

    private val input = File("src/main/resources/advent2018/day10.txt").readLines()
    private var day10 = Day10(input)

    @Test
    fun part1Test() {
        print(day10.part1())
    }

    @Test
    fun part2Test() {
        print(day10.part2())
    }
}