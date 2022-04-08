package com.example.codility

class MaxCounter {
    fun solution(n: Int, arr: IntArray): IntArray {
        val condition = n + 1
        var currentMax = 0
        var lastUpdate = 0
        val countersArray = IntArray(n+1)

        for (i in arr.indices) {
            val currentValue = arr[i]
            if (currentValue == condition) {
                lastUpdate = currentMax
            } else {
                val position = currentValue - 1
                if (countersArray[position] < lastUpdate)
                    countersArray[position] = lastUpdate + 1
                else
                    countersArray[position]++

                if (countersArray[position] > currentMax) {
                    currentMax = countersArray[position]
                }
            }
        }

        for (i in 0 until n) {
            if (countersArray[i] < lastUpdate)
                countersArray[i] = lastUpdate
        }
        return removeLastItem(countersArray)
    }

    private fun removeLastItem(array: IntArray): IntArray {
        return array.copyOf(array.lastIndex)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(MaxCounter().solution(2, intArrayOf(1, 2, 3, 1, 2)).contentToString())
        }
    }
}