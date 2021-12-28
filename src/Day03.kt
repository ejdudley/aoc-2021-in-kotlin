import java.lang.Math.abs

fun main() {

    fun part1(input: List<String>, wordSize:Int): Int {

        val listLen = input.size

        val counterArray = IntArray(wordSize)

        for (i in 0 until listLen) {
            val currRow = input[i]
            currRow.mapIndexed{idx,v -> counterArray[idx] += v.digitToInt()}
        }

        val limit = listLen / 2

        val gammaBits = counterArray.fold(""){str, v -> str + if(v > limit) "1" else "0"}

        val gamma = gammaBits.toInt(2)
        val maxVal = "1".repeat(wordSize).toInt(2)
        val epsilon = maxVal - gamma

        return gamma * epsilon

    }

    fun part2(input: List<String>): Int {

        fun iterFn(inputList : List<String>, pos:Int, useMostCommon:Boolean) : String {

            val inputListLen = inputList.size
            if(inputListLen == 1) return inputList[0]
            else {
                var countOnes = 0
                for (i in 0 until inputListLen) {
                    val currRow = inputList[i]
                    if(currRow[pos] == '1') countOnes++
                }

                val mostCommonDigit = if(countOnes >= inputListLen/2.0) 1 else 0
                val reqdDigit = if (useMostCommon) mostCommonDigit else kotlin.math.abs(1 - mostCommonDigit)
                val reqdDigitChr = reqdDigit.digitToChar()
                val newList = inputList.filter { it[pos] == reqdDigitChr }

                return iterFn(newList, pos+1, useMostCommon)
            }
        }

        val oxygen = iterFn(input, 0, true)
        val co2 = iterFn(input, 0, false)

        //println("oxygen = $oxygen, co2 = $co2")

        return oxygen.toInt(2) * co2.toInt(2)

    }

    val testInput = readInput("Day03_test")
    val input = readInput("Day03")

    check(part1(testInput, 5) == 198)
    println(part1(input, 12))

    check(part2(testInput)==230)
    println(part2(input))
}