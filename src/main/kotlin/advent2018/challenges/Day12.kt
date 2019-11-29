package advent2018.challenges

class Day12 (inputList: List<String>) {

    var initialState: String = inputList[0].removePrefix("initial state: ")

    var listRules = inputList.drop(2).map { it.split(" => ") }.map { it[0] to it[1][0] }.toMap()

    fun part1(): Long {
        var nextState = initialState
        nextState = ".$nextState."
        val generations = 20
        var iteration = 0

        var totalCount = 0
        for(i in 1..generations) {
            var list = listOf('.','.','.') + nextState.toList().toMutableList() + listOf('.','.',',')

            var nextGen = ""
            for(c in 2..(list.size - 3)) {
                val plantsAround: String = list.joinToString("").substring(c-2, c+3)

                if (listRules.containsKey(plantsAround)) {
                    nextGen += listRules.getValue(plantsAround)
                }

                else nextGen += "."


            }
            totalCount += nextGen.toCharArray().count{ it == '#' }
            iteration = i
            nextGen = nextGen.drop(0)
            nextState = nextGen

        }


        val totalResult = nextState.toCharArray()
        var indexPlantZero = generations
        var resultSum: Long = 0
        for (i in 0 until totalResult.size) {
            if (totalResult[i] == '#') resultSum += (i-indexPlantZero - 1)
        }
        println(iteration)

        return resultSum


    }

    fun part2(): Long {
        var nextState = initialState
        nextState = ".$nextState."
        val generations = 50000000000L

        var totalCount = 0
        var iteration = 0L

        for(i in 1..generations) {
            var list = listOf('.','.','.') + nextState.toList().toMutableList() + listOf('.','.',',')

            var nextGen = ""
            for(c in 2..(list.size - 3)) {
                val plantsAround: String = list.joinToString("").substring(c-2, c+3)

                if (listRules.containsKey(plantsAround)) {
                    nextGen += listRules.getValue(plantsAround)
                }

                else nextGen += "."


            }
            totalCount += nextGen.toCharArray().count{ it == '#' }
            iteration = i
            println(nextGen)
            println(nextGen.length)
            if (nextGen.contains(nextState.drop(1))) {
                nextState = nextGen
                println(nextGen.toCharArray().drop(iteration.toInt()).joinToString(""))
                break
            }
            nextGen = nextGen.drop(0)
            nextState = nextGen


        }


        val totalResult = nextState.toCharArray()
        var resultSum: Long = 0
        for (i in 0 until totalResult.size) {
            if (totalResult[i] == '#') resultSum += (i + generations - iteration - iteration - 1)
        }
        return resultSum

        //1700000000011


    }

}


