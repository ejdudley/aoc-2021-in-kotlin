fun main() {

    fun part1(input: List<String>): Int {

        val n = input.map { it.toInt() }
            .reduceIndexed { index, acc, _ -> acc + if (input[index] > input[index - 1]) 1 else 0 }

        return n - input[0].toInt()
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))

}