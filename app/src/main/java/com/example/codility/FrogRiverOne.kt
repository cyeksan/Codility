package com.example.codility

class FrogRiverOne {
    fun solution(x: Int, arr: IntArray): Int {
        val leaves = HashMap<Int, Boolean>()
        for((index, value) in arr.withIndex()) {
            leaves[value] = true
            if(leaves.size == x) {
                return index
            }
        }
        return -1
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(FrogRiverOne().solution(5, intArrayOf(1, 3, 1, 4, 2, 3, 5, 4)))
        }
    }
}