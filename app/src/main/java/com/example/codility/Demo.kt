package com.example.codility

import java.util.*

class Demo {
    fun solution(A: IntArray): Int {
        var smallestInt = 1

        if (A.isEmpty()) return smallestInt

        Arrays.sort(A)

        if (A[0] > 1) return smallestInt
        if (A[A.size - 1] <= 0) return smallestInt

        for (element in A) {
            if (element == smallestInt) {
                smallestInt++
            }
        }

        return smallestInt

        /*val list = A.toList().distinct()
        return (1..list.size+1).sum() - list.sum()*/
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(Demo().solution(intArrayOf(1,3,6,4,1,2))) //5
            println(Demo().solution(intArrayOf(1,2,3))) //4
            println(Demo().solution(intArrayOf(-1, -3))) //1


        }
    }
}