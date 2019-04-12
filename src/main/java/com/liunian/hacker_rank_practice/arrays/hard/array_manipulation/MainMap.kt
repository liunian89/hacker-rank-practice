package com.liunian.hacker_rank_practice.arrays.hard.array_manipulation

import java.util.*

class MainMap {
    // Complete the arrayManipulation function below.
    fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
        val scoreTable = mutableMapOf<Int, Long>()
        queries.forEach { row ->
            scoreTable.compute(row[0]) { _, v -> (v ?: 0) + row[2] }
            scoreTable.compute(row[1] + 1) { _, v -> (v ?: 0) - row[2] }
        }

        val array = Array(n) { 0L }

        var max = 0L
        IntRange(1, n).fold(0L) { acc, i ->
            val new = acc + (scoreTable[i] ?: 0)
            array[i - 1] = new
            if (new > max) max = new
            new
        }

        return max
    }

    fun main(args: Array<String>) {
        val scan = Scanner(System.`in`)

        val nm = scan.nextLine().split(" ")

        val n = nm[0].trim().toInt()

        val m = nm[1].trim().toInt()

        val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

        for (i in 0 until m) {
            queries[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        }

        val result = arrayManipulation(n, queries)

        println(result)
    }
}
