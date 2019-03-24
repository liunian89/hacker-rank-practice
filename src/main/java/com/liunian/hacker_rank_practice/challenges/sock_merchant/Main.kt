package com.liunian.hacker_rank_practice.challenges.sock_merchant

import java.util.*

/**
 *  https://www.hackerrank.com/challenges/sock-merchant/problem
 */
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").filter { it.isNotBlank() }.map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    return ar.groupingBy { it }
            .eachCount()
            .values
//            .fold(0) { acc, i -> acc + i / 2 }
            .fold(0) { acc, i -> acc + (i shr 1) }
}

