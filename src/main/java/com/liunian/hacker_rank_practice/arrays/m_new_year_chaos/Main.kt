package com.liunian.hacker_rank_practice.arrays.m_new_year_chaos

import java.util.*
import kotlin.math.max

// Complete the minimumBribes function below.
fun minimumBribes(finalState: Array<Int>): Unit {
    val initialState = IntArray(finalState.size) { it + 1 }.toTypedArray()
    val counts = IntRange(1, finalState.size).map { it to 0 }.toMap().toMutableMap()
    try {
        transform(initialState, finalState, counts)
        println(counts.values.sum())
    } catch (e: RuntimeException) {
        println("Too chaotic")
    }
}

private fun transform(initialState: Array<Int>, finalState: Array<Int>, counts: MutableMap<Int, Int>) {
    for (finalIndex in finalState.size - 1 downTo 0) {
        val initialIndex = initialState.indexOf(finalState[finalIndex])
        if (finalIndex > initialIndex) {
            initialState.swapBackwards(initialIndex, finalIndex, counts)
        } else if (finalIndex < initialIndex) {
            initialState.swapForwards(initialIndex, finalIndex, counts)
        }
    }
}


private fun Array<Int>.swapBackwards(fromIndex: Int, toIndex: Int, counts: MutableMap<Int, Int>): Array<Int> {
    return IntRange(fromIndex, toIndex - 1)
            .fold(this) { acc, i -> acc.swap(i, i + 1, counts) }
}

private fun Array<Int>.swapForwards(fromIndex: Int, toIndex: Int, counts: MutableMap<Int, Int>): Array<Int> {
    return (fromIndex downTo toIndex + 1)
            .fold(this) { acc, i -> acc.swap(i, i - 1, counts) }
}

private fun Array<Int>.swap(index1: Int, index2: Int, counts: MutableMap<Int, Int>): Array<Int> {
    val back = this[max(index1, index2)]
    this[index1] = this[index2].also { this[index2] = this[index1] }
    counts.increment(back)
    return this
}

private fun MutableMap<Int, Int>.increment(key: Int) {
    val current = this[key]!!
    if (current == 2) {
        throw RuntimeException("cannot take more than 2 bribes!")
    }
    this[key] = current + 1
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()
    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()
        val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        minimumBribes(q)
    }
}
