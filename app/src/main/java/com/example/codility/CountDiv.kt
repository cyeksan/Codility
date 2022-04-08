package com.example.codility

class CountDiv {
    fun solution(A: Int, B: Int,K: Int): Int {
        return if(A % K == 0) {
            B/K - A/K +  1
        } else {
            B/K - A/K
        }
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(CountDiv().solution(5, 12, 2)) //4
            println(CountDiv().solution(5, 13, 2)) //4
            println(CountDiv().solution(6, 12, 2)) //4
            println(CountDiv().solution(10, 20, 10)) //2
            println(CountDiv().solution(9, 21, 10)) //2
            println(CountDiv().solution(0, 0, 1)) //1
        }
    }
}