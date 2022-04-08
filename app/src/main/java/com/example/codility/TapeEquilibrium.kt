package com.example.codility

import kotlin.math.abs

class TapeEquilibrium {

    fun solution(arr: IntArray): Int {
        if(arr.size == 2) {
            return arr[1] - arr[0]
        }
        var best: Int? = null
        var before = 0
        var after = arr.sum()
        // adjust and test at every split
        for(i in arr) {
            before += i
            after -= i
            val difference = abs(before - after)
            if (best == null || difference < best){
                best = difference
            }
        }
        return best!!
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(TapeEquilibrium().solution(intArrayOf(3, 1, 2, 4, 3)))
        }
    }
}