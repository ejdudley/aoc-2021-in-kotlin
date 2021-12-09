fun main() {

    fun part1(input: List<String>): Int {

        val listLen = input.size
        var count = 0
        for (i in 1 until listLen) {
            if (input[i].toInt() > input[i-1].toInt()) count++
        }

       return count

    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))

}