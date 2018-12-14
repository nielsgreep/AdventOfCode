package advent2018.challenges

class Day14(input: Int) {

    var input = input

    fun part1(): String {

        val afterHowManyRecipes = input
        val atLeast = afterHowManyRecipes + 10


        var result = makeRecipes().find { it.size >= atLeast }


        return result!!.subList(afterHowManyRecipes, atLeast).joinToString("")
    }

    fun part2(): Int {

        var recipe = input.toString()


        var result = makeRecipes().find {
            it.takeLast(7).joinToString("").contains(recipe)  }!!.joinToString("").indexOf(recipe)

        return result

    } //20330674





    fun makeRecipes(): Sequence<MutableList<Int>> {

        var elfPosition1 = 0
        var elfPosition2 = 1

        val recipes = mutableListOf(3, 7)

        var counter = 1

        return generateSequence {


            println(counter)

            val scoreElf1 = recipes[elfPosition1]
            val scoreElf2 = recipes[elfPosition2]
            val result = scoreElf1 + scoreElf2

            if (result >= 10) {
                recipes.add(result / 10)
            }
            recipes.add(result % 10)

            elfPosition1 = (1 + scoreElf1 + elfPosition1) % recipes.size
            elfPosition2 = (1 + scoreElf2 + elfPosition2) % recipes.size

            counter++

            recipes

        }

    }


}