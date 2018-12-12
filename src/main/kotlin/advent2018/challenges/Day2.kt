package advent2018.challenges

class Day2(inputList: MutableList<String>) {

    private val input: MutableList<String> = inputList

    fun part1(): Int {

        var countTwo = 0
        var countThree = 0
        input.forEach { str ->

            str.map { ch -> str.count {strC -> ch == strC } }
                    .let {
                        if (it.contains(2)) countTwo++
                        if (it.contains(3)) countThree++
                    }
        }

        return countTwo * countThree

    }

    fun part2(): String {

        for (line in input) {
            for (lineToCompare in input) {
                if (line != lineToCompare && isDifferentByOne(line, lineToCompare))
                    return removeDifferentChar(line, lineToCompare)
            }
        }

        throw NoSuchElementException("Nothing")

    }

    private fun removeDifferentChar(line: String, lineToCompare: String): String {

        var stringWithCharRemoved = ""

        for (i in 0 until line.toCharArray().size ) {
            if (line[i] == lineToCompare[i]) stringWithCharRemoved += line[i]
        }

        return stringWithCharRemoved

    }

    private fun isDifferentByOne(line: String, lineToCompare: String): Boolean {
        var charsThatAreDifferent = 0
        for (i in 0 until line.toCharArray().size) {
            if (line[i] != lineToCompare[i]) charsThatAreDifferent++
        }

        return charsThatAreDifferent <= 1
    }


}