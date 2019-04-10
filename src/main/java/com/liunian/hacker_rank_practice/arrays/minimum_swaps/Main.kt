package com.liunian.hacker_rank_practice.arrays.minimum_swaps

import java.util.*
import kotlin.math.absoluteValue

fun minimumSwaps(arr: Array<Int>): Int {
    var i = 0
    var count = 0
    while (i < arr.size) {
        if (arr[i] == i + 1) {
            i++
        } else {
            arr[i] = arr[arr[i] - 1].also { arr[arr[i] - 1] = arr[i] }
            count++
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}


class Solution1 {

    fun minimumSwaps(arr: Array<Int>): Int {

        var count = 0
        var diff = arr.diff()
        while (diff.isNotEmpty()) {

            val bestImprovement = diff.map { it.distanceAfterSwap.absoluteValue }.min()
            val one = diff.first { it.distanceAfterSwap.absoluteValue == bestImprovement }
            arr[one.value - 1] = one.value.also { arr[one.index] = arr[one.value - 1] }
            count++
            diff = arr.diff()
        }

        return count
    }

    //(index + 1 - num) + (num - 1 + 1) - this[num - 1]
    private fun Array<Int>.diff(): List<Element> {
        val mapIndexed = this
                .mapIndexed { index, num -> Element(num, index, index + 1 - this[num - 1]) }
                .filter { it.value != it.index + 1 }
        return mapIndexed
    }

    data class Element(val value: Int, val index: Int, val distanceAfterSwap: Int)

    fun main(args: Array<String>) {
        val scan = Scanner(System.`in`)

        val n = scan.nextLine().trim().toInt()

        val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        val res = minimumSwaps(arr)

        println(res)
    }

}