package advent2018.challenges

class Day7(inputList: List<String>) {


    private val input: List<String> = inputList
    private var listOfPairs: MutableList<Pair<Char, Char>> = input.map { toPair(it) }.toMutableList()
    private var listOfJobsWaiting: MutableList<Char> = mutableListOf()
    private var listOfJobsDoing: MutableList<Pair<Char, Int>> = mutableListOf()
    private var listOfJobsDone: MutableList<Pair<String, Int>> = mutableListOf()
    private var result: String = ""
    private var theLastStep: String = ""




    private fun toPair(line: String): Pair<Char, Char> {
        return Pair(line[5], line[36])

    }

    //todo + 60
    private fun secondsForTheJob(a: Char): Int = a.toInt() - 'A'.toInt()

    private fun findNextStep(list: List<Pair<Char, Char>>): Char {

        val listOfA = list.map { it.first }
        val listOfB = list.map { it.second }

        val listOfPossible = listOfA.filter { !listOfB.contains(it) }

        if (listOfA.size == 1) {
            theLastStep = listOfB.first().toString()
        }

        else if (listOfPossible.size == 1) return listOfPossible.first()

        return listOfPossible.minBy { it }!!

    }

    fun part1(): String {

        while (listOfPairs.isNotEmpty()) {

            val theNextStep = findNextStep(listOfPairs)

            result += theNextStep
            listOfPairs = listOfPairs.filter { it.first != theNextStep }.toMutableList()


        }

        return result + theLastStep

    }

    fun part2(): Int {

        var countSeconds = 0

        while (listOfPairs.isNotEmpty()) {

            listOfJobsDoing = listOfJobsDoing.filter { it.second != countSeconds }.toMutableList()

            if (listOfJobsDoing.isEmpty()) {
                val theNextStep = findNextStep(listOfPairs)
                listOfJobsDoing.add(Pair(theNextStep, countSeconds + secondsForTheJob(theNextStep)))
                listOfPairs = listOfPairs.filter { it.first != theNextStep }.toMutableList()
            }



            countSeconds++

        }
        return countSeconds

    }

}