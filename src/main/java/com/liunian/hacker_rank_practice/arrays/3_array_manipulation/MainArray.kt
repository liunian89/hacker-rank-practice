package com.liunian.hacker_rank_practice.arrays.`3_array_manipulation`

import java.util.*

/**
 * Array performance better than hashmap
 *
 * A big difference is the time complexities. In worst case a lookup in a HashMap will take O(n) time.
 * This happens if the HashCode is implemented poorly and all the items end up with the same HashCode.
 * In an array however, a lookup is always constant time O(1).
 */
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val diff = Array(n + 1) { 0L }

    queries.forEach { row ->
        diff[row[0] - 1] = diff[row[0] - 1] + row[2]
        diff[row[1]] = diff[row[1]] - row[2]

    }

    var max = 0L
    IntRange(1, n).fold(0L) { acc, i ->
        val new = acc + diff[i - 1]
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
