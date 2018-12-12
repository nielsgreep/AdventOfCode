package advent2018.challenges

class Day5(private var input: String) {


    fun part1(): Int {

        return react(input).length
    }

    fun part2(): Int? {

        val listOfSizes = mutableListOf<Int>()

        for (i in 'a'..'z') {
            val charlessString = input.replace(i.toString(), "", true)

            listOfSizes.add(react(charlessString).length)
        }

        return listOfSizes.min()

    }

    private fun react(input: String): String {
        val stringInput = StringBuilder(input)

        while (true) {

            var breakLoop = false
            for (i in (0 until stringInput.length - 1)) {
                if (stringInput[i].toLowerCase() == stringInput[i+1].toLowerCase() && stringInput[i] != stringInput[i+1]) {
                    stringInput.delete(i, i+2)
                    breakLoop = true
                    break

                }
            }

            if(!breakLoop) {
                break
            }
        }

        return stringInput.toString()

    }

}