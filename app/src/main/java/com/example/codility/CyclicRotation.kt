package com.example.codility

class CyclicRotation {
    fun solution(arr: IntArray, k: Int) : IntArray{
        if (arr.isEmpty()) {
            return arr
        }
        // netK is the net number of shifts to apply (omits spinning round and round)
        val netK = (arr.size + k) % arr.size
        if (netK > 0) {
            val left = arr.copyOfRange(arr.size - netK, arr.size)
            val right = arr.copyOfRange(0, arr.size - netK)
            return left + right
        }
        return arr
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(CyclicRotation().solution(intArrayOf(), 3).contentToString())
        }
    }
}