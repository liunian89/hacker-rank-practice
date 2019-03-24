package com.liunian.hacker_rank_practice.challenges.counting_valleys

import java.util.*

/**
 *  https://www.hackerrank.com/challenges/counting-valleys/problem
 */
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}

// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var counter = 0
    s.trim().toCharArray()
            .map {
                when (it) {
                    'U' -> 1
                    'D' -> -1
                    else -> throw IllegalStateException("Illegal character [$it] in path")
                }
            }
            .fold(0) { acc, i -> if (acc == 0 && i == -1) counter += 1; acc + i }
    return counter
}