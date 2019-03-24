import java.util.*
import kotlin.math.ceil

fun jumpingOnClouds1(clouds: Array<Int>): Int {
    val extraSteps = clouds.mapIndexed { index, i -> i to (index + 1) % 2 }
            .filter { it.first == 1 }
            .map { it.second }
            .fold(Pair(0, 1)) { acc, i -> if (i == acc.second) Pair(acc.first + 1, 1 - acc.second) else acc } // distinct until change, switch between finding 1 and 0 (even / odd)
            .first

    return ceil((clouds.size - extraSteps * 3 - 1) / 2.0).toInt() + extraSteps * 2
}

fun jumpingOnClouds2(clouds: Array<Int>): Int {
    var index = 0
    var step = 0
    while (index < clouds.size - 1) {
        index += if (index + 2 <= clouds.size - 1 && clouds[index + 2] == 0) 2 else 1
        step += 1
    }
    return step
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val clouds = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds2(clouds)

    println(result)
}