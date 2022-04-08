package com.example.codility

class Dominator {
    fun solution(A: IntArray) : Int {
        // Using "hashMap" for counting
        val map: MutableMap<Int, Int> = HashMap()

        // 1. Counting
        // map(key, value) ---> map(number, count)
        for (i in A.indices) {
            if (!map.containsKey(A[i])) { // new number
                map[A[i]] = 1 // "put" new number
            } else {
                val count = map[A[i]]!! // "get" count
                map[A[i]] = count + 1 // count++
            }
        }

        // 2. find the max number of counts
        var maxNumber = 0
        var maxCount = 0
        // note: use "map.keySet()" in for loop
        for (key in map.keys) {
            val curCount = map[key]!! // get value
            if (curCount > maxCount) {
                maxCount = curCount // update max count
                maxNumber = key
            }
        }
        // 3. check if there is a "dominator" or not
        if (maxCount > A.size / 2) {
            // then, max_Number is the "dominator"
        } else {
            return -1 // no dominator
        }

        // 4. return "any index" of "the dominator"
        for (i in A.indices) {
            if (A[i] == maxNumber) {
                return i // return the index
            }
        }

        return -1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(Dominator().solution(intArrayOf(3,4,3,2,3,-1,3,3)))
        }
    }
}