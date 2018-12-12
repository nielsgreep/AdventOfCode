package advent2018.challenges

class Day3(inputList: MutableList<String>) {

    private val input: MutableList<String> = inputList
    private val claims = input.map { it.toClaim() }

    fun part1(): Int {

        return claims.flatMap { it.areaOfClaim() }.groupBy { it }.count { it.value.size > 1 }

    }

    fun part2(): String? {

        return claims.find { claim -> claims.none { claim.id != it.id && claim.overlaps(it) }}?.id

    }


    class Claim(val id: String, val xLeft: Int, val width: Int, val yTop: Int, val height: Int) {

        fun areaOfClaim(): List<Pair<Int, Int>> {

            val listOfPairs = mutableListOf<Pair<Int, Int>>()

            for (x in xLeft until (xLeft + width)) {

                for (y in yTop until (yTop + height)) {
                    listOfPairs.add(Pair(x, y))
                }

            }
            return listOfPairs
        }

        fun overlaps(other: Claim): Boolean {

            val thisRangeX = IntRange(this.xLeft, this.xLeft + this.width)
            val thisRangeY = IntRange(this.yTop, this.yTop + this.height)
            val otherRangeX = IntRange(other.xLeft, other.xLeft + other.width)
            val otherRangeY = IntRange(other.yTop, other.yTop + other.height)

            return thisRangeX.start <= otherRangeX.endInclusive && otherRangeX.start <= thisRangeX.endInclusive && thisRangeY.start <= otherRangeY.endInclusive && otherRangeY.start <= thisRangeY.endInclusive
        }

    }

    private fun String.toClaim(): Claim = split(" ")
            .let {
                val (x, y) = it[2].split(',').map { it.removeSuffix(":").toInt() }
                val (width, height) = it[3].split('x').map { it.toInt() }
                Claim(it[0], x, width, y, height)
            }

}