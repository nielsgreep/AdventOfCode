package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day6Test {


    private val input = File("src/main/resources/advent2018/day6.txt").readLines()
    private var day6 = Day6(input)

    fun part1Test() {
        print(day6.part1())

    }

    fun part2Test() {
        print(day6.part2())

    }
}