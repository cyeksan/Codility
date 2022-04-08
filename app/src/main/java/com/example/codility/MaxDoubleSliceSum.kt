package com.example.codility

import kotlin.math.max

class MaxDoubleSliceSum {
    fun solution(A: IntArray) : Int {
        // (X, Y, Z)
        // 1st slice: A[X+1] + ... + A[Y-1]
        // 2nd slice: A[Y+1] + ... + A[Z-1]
        // Key Point:
        // The array will be split at "Y"

        // main idea:
        // if the middle point is "Y",
        // find "maxLeft" and "maxRight"
        val maxLeft = IntArray(A.size)
        val maxRight = IntArray(A.size)

        // 1) find "maxLeft"
        // maxLeft[i] is the maximum sum "contiguous subsequence" ending at index i
        // note: because it is "contiguous", we only need the ending index (important)
        for (i in 1 until A.size) {   // be careful: from i=1 (because of maxLeft[i-1])
            maxLeft[i] = max(
                0,
                maxLeft[i - 1] + A[i]
            ) //golden slice algorithm: Math.max(0, maxLeft[i-1]+A[i] )
        }

        // 2) find "maxRight"
        // maxRight[i] is the maximum sum "contiguous subsequence" starting at index i
        // note: because it is "contiguous", we only need the starting index (important)
        for (i in A.size - 2 downTo 0) {   // be careful: from i=A.length-2 (because of maxLeft[i+1])
            maxRight[i] = Math.max(
                0,
                maxRight[i + 1] + A[i]
            ) //golden slice algorithm: Math.max(0, maxRight[i+1]+A[i] )
        }

        // 3) find the maximum of "maxLeft + maxRight"
        var maxDoubleSlice = 0
        for (i in 1 until A.size - 1) { // where "i" means "Y" in this problem
            if (maxLeft[i - 1] + maxRight[i + 1] > maxDoubleSlice) // be careful: left end at "i-1" and right begins at "i+1"
                maxDoubleSlice =
                    maxLeft[i - 1] + maxRight[i + 1] // be careful: "not" maxLeft[i] + maxRight[i]
        }
        return maxDoubleSlice
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(MaxDoubleSliceSum().solution(intArrayOf(3, 2, 6, -1, 4, 5, -1, 2))) //17
        }
    }
}