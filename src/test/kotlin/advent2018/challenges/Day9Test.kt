package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day9Test {


    private val input = File("src/main/resources/advent2018/day9.txt").readText()
    private var day9 = Day9(input)

    fun part1Test() {
        print(day9.part1())
    }
}