package com.liunian.hacker_rank_practice.utils

import com.liunian.hacker_rank_practice.hashmap_dict.m_count_triplets.countTriplets
import org.apache.commons.io.FileUtils
import java.io.File


fun read(path: String): List<String> {
    return FileUtils.readLines(File(path), Charsets.UTF_8)
}

fun main(args: Array<String>) {
    val read = read("/Users/nliu/Development/random/hacker-rank-practice/src/main/java/com/liunian/hacker_rank_practice/hashmap_dict/m_count_triplets/input06.txt")
    val nr = read[0].trimEnd().split(" ")
    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = read[1].trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)

}

fun countTriplets1(arr: Array<Long>, r: Long): Long {
    val v2 = mutableMapOf<Long, Long>()
    val v3 = mutableMapOf<Long, Long>()
    var count = 0L
    for (k in arr) {
        count += if (v3[k] == null) 0 else v3[k]!!
        if (v2[k] != null) v3.compute(k * r) { key, value -> if (value != null) value + v2[k]!! else v2[k] }
        v2.compute(k * r) { key, value -> if (value == null) 1 else value + 1 }
        println("$k $v2 $v3")
    }
    return count!!
}