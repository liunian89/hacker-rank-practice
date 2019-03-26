package com.liunian.hacker_rank_practice.arrays.new_year_chaos

import java.util.*

class Main2 {

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

    private fun Array<Int>.swapBackwards(fromIndex: Int, toIndex: Int, counts: MutableMap<Int, Int>) {
        val toMove = this[fromIndex]

        this.slice(IntRange(fromIndex + 1, toIndex))
                .forEachIndexed { index, i ->
                    this[fromIndex + index] = i
                    counts.increment(i)
                }

        this[toIndex] = toMove
    }

    private fun Array<Int>.swapForwards(fromIndex: Int, toIndex: Int, counts: MutableMap<Int, Int>) {
        val toMove = this[fromIndex]

        this.slice(IntRange(fromIndex, toIndex - 1))
                .forEachIndexed { index, i ->
                    this[fromIndex + 1 + index] = i
                    counts.increment(toMove)
                }

        this[toIndex] = toMove
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
}
