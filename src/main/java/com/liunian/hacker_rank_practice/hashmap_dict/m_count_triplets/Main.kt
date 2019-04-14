package com.liunian.hacker_rank_practice.hashmap_dict.m_count_triplets

fun countTriplets(arr: Array<Long>, r: Long): Long {
    val eachCount = arr.groupingBy { it }.eachCount()
    if (r == 1L) {
        return eachCount.entries
                .filter { it.value >= 3 }
                .map { possibilitiesWhenBase1(it.value.toLong()) }
                .sum()
    }

    val sorted = eachCount.keys.sorted()
    val scanned = mutableSetOf<Long>()
    val sequences = mutableListOf<Array<Pair<Long, Long>>>()

    sorted.forEach {
        if (!scanned.contains(it)) {
            sequences.add(eachCount.countSequenceFrom(it, r, scanned))
        }
    }

    val filtered = sequences.filter { it.size >= 3 }

    val sums = filtered.map {
        IntRange(0, it.size - 3)
                .map { i -> it[i].second * it[i + 1].second * it[i + 2].second }
                .sum()
    }
    return sums.sum()
}

fun Map<Long, Int>.countSequenceFrom(base: Long, ratio: Long, scanned: MutableSet<Long>): Array<Pair<Long, Long>> {
    var countList = mutableListOf<Pair<Long, Long>>()
    var num = base
    var count = this[num]
    while (count != null) {
        scanned.add(num)
        countList.add(num to count.toLong())

        num *= ratio
        count = this[num]
    }
    return countList.toTypedArray()
}

fun possibilitiesWhenBase1(n: Long) = n * (n - 1) * (n - 2) / 6

fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}
