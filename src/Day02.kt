fun main() {

    fun part1(input: List<String>): Int {

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
    check(part1(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))

}