package advent2019.challenges

fun main() {

    val input = (231832..767346).asSequence()

    println(input.filter { hasDoubleDigits(it.toString()) && allIncreases(it.toString()) }.count())

    println(input.filter { allIncreases(it.toString()) && hasOneDouble(it.toString()) }.count())

}


private fun hasDoubleDigits(password: String): Boolean {

    return password[0] == password[1] ||
            password[1] == password[2] ||
            password[2] == password[3] ||
            password[3] == password[4] ||
            password[4] == password[5]
}

private fun hasOneDouble(password: String) : Boolean {
    return password.groupBy { it }.filter { it.value.size == 2 }.isNotEmpty()
}

private fun allIncreases(password: String): Boolean {

    return password[0].toInt() <= password[1].toInt() &&
            password[1].toInt() <= password[2].toInt() &&
            password[2].toInt() <= password[3].toInt() &&
            password[3].toInt() <= password[4].toInt() &&
            password[4].toInt() <= password[5].toInt()
}