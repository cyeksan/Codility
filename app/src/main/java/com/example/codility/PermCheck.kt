package com.example.codility

class PermCheck {
    fun solution(arr:IntArray): Int{
        // an empty list is not a permutation
        if (arr.isEmpty())
        return 0

        // track the hits with a hashmap
        val hits = HashMap<Int, Boolean>()

        for(i in arr){
            //(quick exit) each element once and only once thanks
            if(i in hits) {
                return 0
            }
            hits[i] = true
        }

        // (quick exit again) each element once and only once
        if (hits.size != arr.size) {
            return 0
        }

        // ok, see if they're all there
        for (i in arr.indices){
            if (i+1 !in hits){
                return 0
            }
        }
        return 1
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(PermCheck().solution(intArrayOf(3, 2, 1)))
        }
    }
}