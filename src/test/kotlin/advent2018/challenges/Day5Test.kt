package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day5Test {


    private val input = File("src/main/resources/advent2018/day5.txt").readText()
    private var day5 = Day5(input)

    @Test
    fun part1Test() {
        print(day5.part1())
    }

    @Test
    fun part2Test() {
        print(day5.part2())
    }
}