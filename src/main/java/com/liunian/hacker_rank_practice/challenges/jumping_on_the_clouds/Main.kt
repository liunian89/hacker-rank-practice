import java.util.*
import kotlin.math.ceil

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(clouds: Array<Int>): Int {
    val extraSteps = clouds.mapIndexed { index, i -> i to (index + 1) % 2 }
            .filter { it.first == 1 }
            .map { it.second }
            .fold(Pair(0, 1)) { acc, i -> if (i == acc.second) Pair(acc.first + 1, 1 - acc.second) else acc } // distinct until change, switch between finding 1 and 0 (even / odd)
            .first

    return ceil((clouds.size - extraSteps * 3 - 1) / 2.0).toInt() + extraSteps * 2
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val clouds = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(clouds)

    println(result)
}