fun main() {

    fun part1(input: List<String>): Int {

        val listLen = input.size
        var count = 0
        for (i in 1 until listLen) {
            if (input[i].toInt() > input[i-1].toInt()) count++
        }

       return count

    }

    fun part2(input: List<String>): Int {

        val inputInts = input.map { it -> it.toInt() }

        val listLen = input.size - 2
        var prevSum = inputInts.take(3).sum()

        var count = 0

        for (i in 1 until listLen) {
            val currSum = prevSum - inputInts[i - 1] + inputInts[i + 2]
            if (currSum > prevSum) count++
            prevSum = currSum
        }

        return count

    }

    val testInput = readInput("Day01_test")
    val input = readInput("Day01")

    check(part1(testInput) == 7)
    println(part1(input))

    check(part2(testInput) == 5)
    println(part2(input))

}
