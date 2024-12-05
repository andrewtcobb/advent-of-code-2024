package Day1

import println
import readInput
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val leftList = input.map { it.split(" ", limit = 2)[0].trim().toInt() }.sortedDescending()
        val rightList = input.map { it.split(" ", limit = 2)[1].trim().toInt() }.sortedDescending()

        return leftList.withIndex().sumOf { (index, left) -> abs(left - rightList[index]) }
    }

    fun part2(input: List<String>): Int {
        val leftList = input.map { it.split(" ", limit = 2)[0].trim().toInt() }
        val rightList = input.map { it.split(" ", limit = 2)[1].trim().toInt() }
        val rightFrequencyMap = rightList.groupingBy { it }.eachCount()

        return leftList.sumOf { left -> rightFrequencyMap[left]?.let { it * left } ?: 0 }
    }


    val testInput = readInput("Day1/test-input")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/input.txt` file.
    val input = readInput("Day1/input")
    part1(input).println()
    part2(input).println()
}
