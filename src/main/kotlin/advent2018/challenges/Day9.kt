package advent2018.challenges

class Day9(inputString: String) {


    val players = inputString.substring(0..inputString.indexOf(" players")).trim().toInt()
    val marbles = inputString.substring(inputString.indexOf("worth ") + 6..inputString.indexOf(" points")).trim().toInt()
    val scores = MutableList(players) {0}


    fun part1() {
        solve()
        println(players)
        println(marbles)
        println(scores)
    }

    fun solve() {

        var currentPlayer = 0

        for (marble in 1.. marbles) {

            if (marble % 23 == 0) scores[currentPlayer] += marble

            currentPlayer = (currentPlayer + 1) % players
        }

    }

}