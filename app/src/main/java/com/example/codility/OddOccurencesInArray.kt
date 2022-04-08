package com.example.codility

class OddOccurencesInArray() {

    fun solution(arr: IntArray): Int {
        if (arr.isEmpty()){
            println("Input list must not be empty")
            return 0
        }
        if(arr.size > MAX_LENGTH) {
            println("Input list must not be longer than $MAX_LENGTH")
            return 0
        }

        val hashSet = HashSet<Int>()

        for(i in arr) {
            if(!hashSet.contains(i)) {
                hashSet.add(i)
            }
            else {
                hashSet.remove(i)
            }
        }
        return hashSet.iterator().next()
    }

    companion object {
        const val MAX_LENGTH = 1000000
        @JvmStatic
        fun main(args: Array<String>){
            println(OddOccurencesInArray().solution(intArrayOf(9, 3, 9, 3, 9, 7, 9)))
        }
    }
}