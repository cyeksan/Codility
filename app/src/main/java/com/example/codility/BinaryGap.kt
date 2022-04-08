package com.example.codility

class BinaryGap() {

    fun solution(number: Int) : Int {
        val binaryNum = number.toUInt().toString(radix = 2)
        var maxCount : Int? = null
        var thisCount = 0
        var wasZero = false
        if(number < 1 || number > maxInt) {
            println("Number not valid")
            return 0
        }
        for(i in binaryNum) {
            val isZero = i.toString() == "0"
            if (wasZero != isZero){
                if(maxCount == null) {
                    maxCount = 0
                }
                else if (thisCount > maxCount) {
                    maxCount = thisCount
                }
                thisCount = 1
            } else {
                thisCount++
            }
            wasZero = isZero
        }
        return maxCount ?: 0
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(BinaryGap().solution(1041))
        }
        const val maxInt = 2147483647
    }
}