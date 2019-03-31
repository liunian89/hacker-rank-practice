package com.liunian.hacker_rank_practice.algorithms.magic_square

import java.util.*
import kotlin.math.absoluteValue

fun formingMagicSquare(s: Array<Array<Int>>): Int {
    val sequence = s.toSequence()

    val possibilities = arrayOf(
            arrayOf(8, 3, 4, 9, 2, 7, 6, 1, 5),
            arrayOf(4, 9, 2, 7, 6, 1, 8, 3, 5),
            arrayOf(2, 7, 6, 1, 8, 3, 4, 9, 5),
            arrayOf(6, 1, 8, 3, 4, 9, 2, 7, 5),
            arrayOf(8, 1, 6, 7, 2, 9, 4, 3, 5),
            arrayOf(6, 7, 2, 9, 4, 3, 8, 1, 5),
            arrayOf(2, 9, 4, 3, 8, 1, 6, 7, 5),
            arrayOf(4, 3, 8, 1, 6, 7, 2, 9, 5)
    )

    return possibilities.map { it.zip(sequence) { a, b -> (a - b).absoluteValue }.sum() }
            .min()!!
}

private fun Array<Array<Int>>.toSequence() = arrayOf(this[0][0], this[0][1], this[0][2], this[1][2], this[2][2], this[2][1], this[2][0], this[1][0], this[1][1])

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = Array<Array<Int>>(3, { Array<Int>(3, { 0 }) })

    for (i in 0 until 3) {
        s[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = formingMagicSquare(s)

    println(result)
}
