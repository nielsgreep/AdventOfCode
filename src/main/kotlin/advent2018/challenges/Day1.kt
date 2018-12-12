package advent2018.challenges

class Day1(inputList: List<String>) {

    private val intList: List<Int> = inputList.map { it.toInt() }

    fun part1(): Int {

        return intList.sum()
    }

    fun part2(): Int {

        val frequents = mutableListOf(0)
        var sum = 0

        repeat(200) {
            for (i in intList) {
                sum += i

                if (frequents.contains(sum)) return sum

                frequents.add(sum)

            }
        }

        throw NoSuchElementException("Nothing")
    }
}
