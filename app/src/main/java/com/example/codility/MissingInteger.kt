package com.example.codility

class MissingInteger {
    fun solution(arr: IntArray) : Int {
        var solution = 1
        val hashSet: HashSet<Int> = HashSet()

        for (i in arr.indices) {
            if (arr[i] < 1) continue
            if (hashSet.add(arr[i])) {
                //this int was not handled before
                while (hashSet.contains(solution)) {
                    solution++
                }
            }
        }

        return solution
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(MissingInteger().solution(intArrayOf(1, 3, 6, 4, 1, 2, 5)))
        }
    }
}