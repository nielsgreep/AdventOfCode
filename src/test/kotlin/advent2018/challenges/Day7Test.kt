package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day7Test {


    private val input = File("src/main/resources/advent2018/day7.txt").readLines()
    private var day7 = Day7(input)

    @Test
    fun part1Test() {
        print(day7.part1())
    }

    @Test
    fun part2Test() {
        print(day7.part2())

    }
}