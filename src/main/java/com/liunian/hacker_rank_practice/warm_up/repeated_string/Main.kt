package com.liunian.hacker_rank_practice.warm_up.repeated_string

import java.util.*

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    val countA = { string: String -> string.count { it == 'a' } }
    return n / s.length * countA(s) + countA(s.substring(0, (n % s.length).toInt()))
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}