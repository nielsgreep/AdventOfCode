package advent2019.Utils

import java.io.File


fun readInputOfDayAsStringList(day: Int): List<String> {

    val pathName = "src/main/resources/advent2019/day$day.txt"

    return File(pathName).readLines()

}

fun readInputAsString(day: Int): String {
    val pathName = "src/main/resources/advent2019/day$day.txt"

    return File(pathName).readText()
}


