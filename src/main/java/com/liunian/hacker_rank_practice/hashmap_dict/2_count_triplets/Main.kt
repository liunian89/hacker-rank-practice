package com.liunian.hacker_rank_practice.hashmap_dict.`2_count_triplets`

import kotlin.math.log

// Complete the countTriplets function below.
fun countTriplets(arr: Array<Long>, r: Long): Long {
    val logArray = arr.map { log(it.toDouble(), r.toDouble()).toLong() }.toTypedArray()
    val eachCount = logArray.groupingBy { it }.eachCount()
    return LongRange(logArray[0], logArray[logArray.size - 1] - 2)
            .map { (eachCount[it] ?: 0) * (eachCount[it + 1] ?: 0) * (eachCount[it + 2] ?: 0) }
            .sum()
            .toLong()
}

fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}
