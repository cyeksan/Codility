package com.example.codility

class FrogJmp {
    fun solution(x: Int, y: Int, d: Int): Int {
        val division = (y-x)/d
        val remaining = (y-x)%d
        return if(remaining == 0) {
            division
        } else {
            division + 1
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(FrogJmp().solution(0, 10, 20))
        }
    }
}