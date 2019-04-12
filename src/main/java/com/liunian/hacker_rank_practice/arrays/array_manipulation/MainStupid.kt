package com.liunian.hacker_rank_practice.arrays.array_manipulation

import java.util.*

class MainStupid {

    // Complete the arrayManipulation function below.
    fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
        val scoreTable = mutableMapOf<Int, Long>()
        queries.forEach { row ->
            IntRange(row[0], row[1]).forEach {
                scoreTable.compute(it) { _, v -> row[2] + (v ?: 0) }
            }
        }


        return scoreTable.values.max()!!
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
