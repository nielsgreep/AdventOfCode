package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day4Test {

    private val input = File("src/main/resources/advent2018/day4.txt").readLines()
    private var day4 = Day4(input.toMutableList())

    @Test
    fun part1Test() {
        print(day4.part1())
    }

}