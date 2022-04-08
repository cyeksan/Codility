package com.example.codility

class Distinct {
    fun solution(A: IntArray) : Int {
        val hashMap = HashMap<Int, Boolean>()
        for(i in A) {
            hashMap[i] = true
        }
        return hashMap.size
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(Distinct().solution(intArrayOf(2, 1, 1, 2, 3, 1, -5, 1, 0)))
        }
    }
}