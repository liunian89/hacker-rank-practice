package com.liunian.hacker_rank_practice.utils

import com.liunian.hacker_rank_practice.hashmap_dict.m_frequency_queries.freqQuery

fun main(args:Array<String>) {
    val read = read("/Users/nliu/Development/random/hacker-rank-practice/src/main/java/com/liunian/hacker_rank_practice/hashmap_dict/m_frequency_queries/input13.txt")

    val q = read[0].trim().toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })

    for (i in 0 until q) {
        queries[i] = read[i+1].trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}