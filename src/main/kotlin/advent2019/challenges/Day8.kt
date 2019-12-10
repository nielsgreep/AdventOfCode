package advent2019.challenges

import advent2019.Utils.readInputAsString

val width = 25
val length = 6
val line = width * length

fun main() {

    val input = readInputAsString(8)


    val leastZeros = input.chunked(line)
            .map { layer -> layer.groupingBy { it }.eachCount() }
            .minBy { it.get('0')!! }

    println(leastZeros.let { it!!.get('1')?.times(it.get('2')!!) })

    renderImage(input.chunked(line))
}

private fun renderImage(layers: List<String>) {

    (0 until line)
            .map { layers.determinePixelAt(it) }
            .chunked(width)
            .forEach {
                println(it.joinToString(separator = ""))
            }

}

private fun List<String>.determinePixelAt(index: Int): Char =
    if(map { it[index] }.firstOrNull { it != '2' } == '1') '#' else ' '
