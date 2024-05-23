package com.example.cimb

fun main(args: Array<String>) {
    val shouldReturnFive = arrayOf<Short>(7,1,5,3,6,4)
    val shouldReturnZero = arrayOf<Short>(7,6,4,3,1)
    println("First Question find maximum profit")
    println("----------------------------------------")
    println("\n")
    println("Should return 5 : " + findMaxProfit(shouldReturnFive))
    println("Should return 0 : " + findMaxProfit(shouldReturnZero))
    println("\n")
    println("----------------------------------------")
}


// Question 1
fun findMaxProfit(input : Array<Short>) : Int {
    if (input.isEmpty()) return 0
    var smallestAmount : Short = Short.MAX_VALUE
    var maxProfit  = 0
    input.forEach {
        if (it < smallestAmount ) {
            smallestAmount = it
        } else if (it - smallestAmount > maxProfit) {
            maxProfit = it - smallestAmount
        }
    }
    return maxProfit
}
