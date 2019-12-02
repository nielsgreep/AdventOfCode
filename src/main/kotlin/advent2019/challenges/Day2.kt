package advent2019.challenges

import advent2019.Utils.readInputAsString


fun main() {

    val input = readInputAsString(2).split(",").map { it.toInt() }

    val noun = 12
    val verb = 2

    println(part1(input, noun, verb))
    println(part2(input))
}


fun part1(input: List<Int>, noun: Int, verb: Int): Int {

    val mutableList = input.toMutableList()

    mutableList[1] = noun
    mutableList[2] = verb

    for (i in mutableList.indices step 4) {
        when(mutableList[i]) {
            99 -> return mutableList[0]
            1 -> mutableList[mutableList[i+3]] = mutableList[mutableList[i+1]] + mutableList[mutableList[i+2]]
            2 -> mutableList[mutableList[i+3]] = mutableList[mutableList[i+1]] * mutableList[mutableList[i+2]]
        }
    }

    return input[0]

}

fun part2(input: List<Int>): Int {

    for(i in 0..99) {
        for(j in 0..99) {
            if (part1(input, i, j) == 19690720) {
                return 100 * i + j
            }
        }
    }



    throw Exception("not found")
}