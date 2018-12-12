package advent2018.challenges

import org.junit.Test
import java.io.File

internal class Day12Test {

    private val input = File("src/main/resources/advent2018/day12.txt").readLines()
    private var day12 = Day12(input)


    @Test
    fun part1Test() {
        print(day12.part1())
    }


}