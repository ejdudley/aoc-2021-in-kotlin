fun main() {

    fun part1(input: List<String>): Int {

        var pos = Pair(0, 0)

        val listLen = input.size

        for (i in 0 until listLen) {

            val currRow = input[i].split(" ")
            val mvmt = currRow[1].toInt()

            pos = when (currRow[0]) {
                "forward" -> Pair(pos.first + mvmt, pos.second)
                "up" -> Pair(pos.first, pos.second - mvmt)
                "down" -> Pair(pos.first, pos.second + mvmt)
                else -> {
                    print("unknown instruction: ${currRow[0]}")
                    Pair(0, 0)
                }
            }
        }

        return pos.first * pos.second

    }

    fun part2(input: List<String>): Int {

        var pos = Triple(0, 0, 0)

        val listLen = input.size

        for (i in 0 until listLen) {

            val currRow = input[i].split(" ")
            val mvmt = currRow[1].toInt()

            pos = when (currRow[0]) {
                "forward" -> Triple(pos.first + mvmt, pos.second + mvmt * pos.third, pos.third)
                "up" -> Triple(pos.first, pos.second, pos.third - mvmt)
                "down" -> Triple(pos.first, pos.second, pos.third + mvmt)
                else -> {
                    print("unknown instruction: ${currRow[0]}")
                    Triple(0, 0, 0)
                }
            }

            //println("$currRow : $pos")
        }

        return pos.first * pos.second

    }

    val testInput = readInput("Day02_test")
    val input = readInput("Day02")

    check(part1(testInput) == 150)
    println(part1(input))

    check(part2(testInput) == 900)
    println(part2(input))

}