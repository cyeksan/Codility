package com.example.codility

class MaxProfit {
    fun solution(A: IntArray): Int {
        if (A.size < 2) {
            return 0
        }

        var minPrice = A[0]
        var maxProfit = 0

        for (value in A) {
            if (value < minPrice) {
                minPrice = value
            } else {
                val currentProfit = value - minPrice
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit
                }
            }
        }
        return maxProfit
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                MaxProfit().solution(
                    intArrayOf(
                        23171,
                        21011,
                        21123,
                        21366,
                        21013,
                        21367
                    )
                )
            ) //356
        }
    }

}