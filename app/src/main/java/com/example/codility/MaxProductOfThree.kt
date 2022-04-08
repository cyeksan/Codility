package com.example.codility

import kotlin.math.max

class MaxProductOfThree {
    fun solution(A: IntArray) : Int {
        val list = A.toMutableList().sorted()
        return if(list[0] < 0 && list[1] < 0 && list[list.lastIndex] > 0) {
            max(list[list.lastIndex] * list[list.lastIndex - 1] * list[list.lastIndex - 2], list[0] * list[1] * list[list.lastIndex])
        } else {
            list[list.lastIndex] * list[list.lastIndex - 1] * list[list.lastIndex - 2]
        }
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(MaxProductOfThree().solution(intArrayOf(-5, 5, -5, 4))) //125
            println(MaxProductOfThree().solution(intArrayOf(-10, -10, -3, 0, 1))) //100
            println(MaxProductOfThree().solution(intArrayOf(-4, -3, -2, -1))) //-6
            println(MaxProductOfThree().solution(intArrayOf(-1, -1, 1, 2))) //2
            println(MaxProductOfThree().solution(intArrayOf(-5, -5, 1, 2))) //50
            println(MaxProductOfThree().solution(intArrayOf(-5, -5, -1, 0))) //0
        }
    }
}