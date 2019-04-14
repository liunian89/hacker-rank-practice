package com.liunian.hacker_rank_practice.arrays.e_dynamic_array

// Complete the dynamicArray function below.
fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
    val array = Array(n) { mutableListOf<Int>() }
    var lastAnswer = 0
    var answers = mutableListOf<Int>()

    queries.forEach {
        when (it.query()) {
            1 -> {
                array[findSequence(it.x(), lastAnswer, n)].add(it.y())
            }
            2 -> {
                val seq = array[findSequence(it.x(), lastAnswer, n)]

                lastAnswer = seq[it.y() % seq.size]
                answers.add(lastAnswer)
            }
        }
    }
    return answers.toTypedArray()
}

private fun Array<Int>.query() = this[0]
private fun Array<Int>.x() = this[1]
private fun Array<Int>.y() = this[2]
private fun findSequence(x: Int, lastAnswer: Int, n: Int) = x.xor(lastAnswer) % n

fun main(args: Array<String>) {
    val nq = readLine()!!.trimEnd().split(" ")
    val n = nq[0].toInt()
    val q = nq[1].toInt()
    val queries = Array<Array<Int>>(q, { Array<Int>(3, { 0 }) })
    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = dynamicArray(n, queries)
    println(result.joinToString("\n"))
}
