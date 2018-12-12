package advent2018.challenges

val numberRegex = """-?\d+""".toRegex()


fun String.extractInts() : IntArray {
    val numbers = numberRegex.findAll(this)
    val out = IntArray(numbers.count())
    var i = 0
    for (number in numbers) {
        out[i++] = number.value.toInt()
    }
    return out
}