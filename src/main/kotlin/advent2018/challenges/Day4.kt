package advent2018.challenges

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Day4(inputList: MutableList<String>) {

    private val input: MutableList<String> = inputList


    fun part1() {
        val dateGuards = input.groupBy { groupDates(it) }.toSortedMap().map { toDayRecord(it) }

        val grouped = dateGuards.groupBy { it.guard }

        println(dateGuards)
    }


    class DayRecord(val date: LocalDate, val guard: Int, val minutesPerDay: MutableList<Int>)


    private fun groupDates(record: String): LocalDate {
        var date = LocalDateTime.parse(record.substring(1, 17), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))

        date = date.plusHours(1)

        return date.toLocalDate()
    }

    fun toDayRecord(map: Map.Entry<LocalDate, List<String>>): DayRecord {

        val listLines = map.value
        val guardId = listLines.first { it.contains("Guard") }.substringAfter("#").substringBefore(" begins shift")
        val minutesAsleep = toRange(listLines.filter { !it.contains("Guard") }.map { it.substring(15, 17).toInt() }.sorted())

        var minutesPerDay: MutableList<Int> = mutableListOf()

        for (range in minutesAsleep) {
            for (i in range) {
                minutesPerDay.add(i)
            }

        }




        return DayRecord(map.key, guardId.toInt(), minutesPerDay)

    }

    fun toRange(list: List<Int>): List<IntRange> {
        var intRangeList: MutableList<IntRange> = mutableListOf()
        for (i in 0 until list.size step 2) {
            intRangeList.add(IntRange(list[i], list[i + 1] - 1))
        }

        return intRangeList
    }


}
