package com.example.codility

import kotlin.math.max

class MaxSliceSum {

    fun solution(A: IntArray) : Int {
        // initial setting A[0]
        var maxEndingPrevious = A[0]
        var maxEndingHere = A[0]
        var maxSoFar = A[0]

        // note: for i=0, it will return A[0] (also for "one element" cases)
        for (i in 1 until A.size) {
            maxEndingHere = max(A[i], maxEndingPrevious + A[i]) // <--- key point~!!
            maxEndingPrevious = maxEndingHere
            maxSoFar = max(maxSoFar, maxEndingHere) // update the max (be careful)
        }

        return maxSoFar // can be used for "all negative" cases

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(MaxSliceSum().solution(intArrayOf(3, 2, -6, 4, 0))) //5
        }
    }
}