package com.liunian.hacker_rank_practice.arrays.`1_hourglass_sum`

import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    return IntRange(0, 3).flatMap { i ->
        IntRange(0, 3).map { j ->
            arr.hourglassSum(i, j)
        }
    }
            .max()!!
}

private fun Array<Array<Int>>.hourglassSum(i: Int, j: Int): Int {
    return this[i].sliceArray(IntRange(j, j + 2)).sum()
            .plus(this[i + 1][j + 1])
            .plus(this[i + 2].sliceArray(IntRange(j, j + 2)).sum())
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}