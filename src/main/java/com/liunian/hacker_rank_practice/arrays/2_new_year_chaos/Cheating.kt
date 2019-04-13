package com.liunian.hacker_rank_practice.arrays.`2_new_year_chaos`

import java.util.*

class Cheating {

    /**
     * For each element, compare with the 2 front ones to see if it necessary to switch
     */
    fun minimumBribes(finalState: Array<Int>): Unit {
        try {
            val count = finalState.foldIndexed(0) { index: Int, count: Int, value: Int ->
                if (value - 1 - index > 2) throw RuntimeException("cannot bribe more than 2 times")
                val subCount = IntRange(Math.max(value - 2, 0), index)
                        .fold(0) { subCount, subIndex -> if (finalState[subIndex] > value) subCount + 1 else subCount }
                subCount + count
            }

            println(count)
        } catch (e: RuntimeException) {
            println("Too chaotic")
        }
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