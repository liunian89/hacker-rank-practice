package com.liunian.hacker_rank_practice.hashmap_dict.m_frequency_queries

fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val countTable = mutableMapOf<Int, Int>()
    val results = mutableListOf<Int>()
    queries.forEach { q ->
        val data = q[1]
        when (q[0]) {

            1 -> countTable.compute(data) { k, v -> (v ?: 0) + 1 }
            2 -> {
                countTable.compute(data) { k, v ->
                    val value = v ?: 0
                    if (value == 0) value
                    else value - 1
                }
            }
            3 -> {
                if (countTable.values.contains(data)) {
                    results.add(1)
                } else {
                    results.add(0)
                }
            }
        }
    }
    return results.toTypedArray()
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}
