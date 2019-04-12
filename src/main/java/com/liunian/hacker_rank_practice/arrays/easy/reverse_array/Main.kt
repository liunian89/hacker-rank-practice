package com.liunian.hacker_rank_practice.arrays.easy.reverse_array

import java.util.*

// Complete the reverseArray function below.
fun reverseArray(a: Array<Int>): Array<Int> {
    val array = Array(a.size) { 0 }
    IntRange(0, a.size - 1).forEach {
        array[it] = a[a.size - 1 - it]
    }
    return array
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arrCount = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = reverseArray(arr)

    println(res.joinToString(" "))
}
