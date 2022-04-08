package com.example.codility

class PermMissingElem {
    fun solution(arr: IntArray) : Int{
        return (1..arr.size+1).sum() - arr.sum()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(PermMissingElem().solution(intArrayOf(2,3,1,5,7,4,8)))
        }
    }
}