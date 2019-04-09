package com.liunian.hacker_rank_practice.arrays.minimum_swaps

import java.util.*
import kotlin.math.absoluteValue

fun minimumSwaps(arr: Array<Int>): Int {

    var count = 0
    var diff = arr.diff()
    while (true) {

        val bestImprovement = diff.values.map { it.distanceAfterSwap.absoluteValue }.min()
        if (bestImprovement == 0) {
            break
        }
        val one = diff.values.first { it.distanceAfterSwap.absoluteValue == bestImprovement }
        val swapped = arr[one.value -1]
        arr[one.value - 1] = one.value.also { arr[one.index] = arr[one.value - 1] }
        count++
        diff.remove(one.value)
        val element = Element( one.index, swapped, diff[arr[one.index]]!!.distanceAfterSwap + one.distanceAfterSwap)
        diff[arr[one.index]] = element
    }

    return count
}

private fun Array<Int>.diff(): MutableMap<Int, Element> {

    val a = this.mapIndexed { index, value -> Triple(index, value, index - value + 1) }
    val b = a.map { Element(it.first, it.second, it.third + it.second - this[it.second - 1]) }
            .filter { it.value != it.index + 1 }
            .map { it.value to it }
            .toMap()
            .toMutableMap()
    return b
}


data class Element(val index: Int, val value: Int, val distanceAfterSwap: Int)

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