package com.example.cimb

fun main(args: Array<String>) {
    val shouldReturnFive = arrayOf<Short>(7, 1, 5, 3, 6, 4)
    val shouldReturnZero = arrayOf<Short>(7, 6, 4, 3, 1)
    println("First Question find maximum profit")
    println("----------------------------------------")
    println("\n")
    println("Ex 1.Should return 5 : " + findMaxProfit(shouldReturnFive))
    println("Ex 2.Should return 0 : " + findMaxProfit(shouldReturnZero))
    println("\n")
    println("----------------------------------------")


    println("Second Question compare version")
    println("----------------------------------------")
    println("\n")
    println("Ex 1.Should return 0 : " + compareVersion("1.01", "1.001"))
    println("Ex 2.Should return 0 : " + compareVersion("1.0", "1.0.0"))
    println("Ex 3.Should return -1 : " + compareVersion("0.1", "1.1"))
    println("Ex 4.Should return 1 : " + compareVersion("0.02", "0.1"))
    println("\n")
    println("----------------------------------------")

    println("Third Question climb to top")
    println("----------------------------------------")
    println("\n")
    println("Ex 1.Should return 2 : " +climbToTop(2))
    println("Ex 2.Should return 3 : " +climbToTop(3))
    println("Ex 2.Should return 3 : " +climbToTop(45))
    println("\n")
    println("----------------------------------------")

    println("Forth Question")
    println("The hardest question is the third one that take much time.")
    println("Firstly, I trying loop to show each step result")
    println("for example 1 -> 1(1),\n2 -> 11,2(2),\n3 -> 111,12,21(3)\n4 -> 1111,112,121,211,22(5) and go on")
    println("then see relation of each step answer will be f(n) = f(n-1) + f(n-2)")
    println("finally, refactor the function to be less complex")

}


// Question 1
fun findMaxProfit(input: Array<Short>): Int {
    if (input.isEmpty()) return 0
    var smallestAmount: Short = Short.MAX_VALUE
    var maxProfit = 0
    input.forEach {
        if (it < smallestAmount) {
            smallestAmount = it
        } else if (it - smallestAmount > maxProfit) {
            maxProfit = it - smallestAmount
        }
    }
    return maxProfit
}

// Question 2
fun compareVersion(version1: String, version2: String): Int {
    val firstVersionList = version1.split(".")
    val secondVersionList = version2.split(".")

    val maxLength = maxOf(firstVersionList.size, secondVersionList.size)

    for (index in 0 until maxLength) {
        val firstVersion = firstVersionList.getOrNull(index)?.toInt() ?: 0
        val secondVersion = secondVersionList.getOrNull(index)?.toInt() ?: 0

        if (firstVersion > secondVersion) {
            return 1
        } else if (firstVersion < secondVersion) {
            return -1
        }
    }
    return 0
}

// Question 3
fun climbToTop(step : Short) : Int {
    val maxStepAtOnce = 2

    if (step <= 1) return 1
    var a = 1
    var b = 1
    for (i in maxStepAtOnce..step) {
        val temp = a + b
        a = b
        b = temp
    }
    return b
}