package com.liunian.hacker_rank_practice.hashmap_dict.`1_ransom_note`

import java.util.*

// Complete the checkMagazine function below.
fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    val noteDict = note.groupingBy { it }.eachCount()
    val magazineDict = magazine.groupingBy { it }.eachCount()

    val isPossible = !noteDict.entries.any { it.value > magazineDict[it.key] ?: 0 }

    println(if (isPossible) "Yes" else "No")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val mn = scan.nextLine().split(" ")

    val m = mn[0].trim().toInt()

    val n = mn[1].trim().toInt()

    val magazine = scan.nextLine().split(" ").toTypedArray()

    val note = scan.nextLine().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}
