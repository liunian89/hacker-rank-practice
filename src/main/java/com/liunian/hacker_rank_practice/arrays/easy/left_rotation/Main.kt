package com.liunian.hacker_rank_practice.arrays.easy.left_rotation

import java.util.*

// Complete the rotLeft function below.
fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val array = Array(a.size) { 0 }
    a.forEachIndexed { index, i -> array[indexOf(index - d, a.size)] = i }
    return array
}

private fun indexOf(index: Int, size: Int): Int {
    return when {
        index >= 0 -> index
        else -> size + index
    }
}

fun rotLeftByLulu(a: Array<Int>, d: Int): Array<Int> {
    val right = a.slice(d until a.size)
    val left = a.slice(0 until d)
    return (right + left).toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
