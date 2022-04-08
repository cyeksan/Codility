package com.example.codility

class Triangle {
    fun solution(A: IntArray) : Int {
        val list = A.toList().sorted()
        for(i in 0..list.size - 3) {
            if(isTriangle(list[i], list[i+1], list[i+2])) {
                return 1
            }
        }
        return 0
    }
    private fun isTriangle(P: Int, Q: Int, R: Int) : Boolean {
        return (P + Q > R) && (P + R > Q) && (R + Q > P)
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(Triangle().solution(intArrayOf(10, 2, 5, 1, 8, 20))) //1
            println(Triangle().solution(intArrayOf(10, 50, 5, 1))) //0

        }
    }
}