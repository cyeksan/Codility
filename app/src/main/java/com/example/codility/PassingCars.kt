package com.example.codility

class PassingCars {
    fun solution(A: IntArray) : Int {
        var east = 0
        var pairs = 0
        for (car in A){
            if(car == 0) {
                east += 1
            }
            else{
                pairs += east
            }
            if (pairs > MAX_PAIRS)
            return -1
        }

        return pairs
    }

    companion object {
        const val MAX_PAIRS = 1e9

        @JvmStatic
        fun main(args: Array<String>){
            println(PassingCars().solution(intArrayOf(0, 0, 1, 1))) //4
            println(PassingCars().solution(intArrayOf(0, 1, 0, 0))) //1
            println(PassingCars().solution(intArrayOf(0, 1, 0, 1))) //3
            println(PassingCars().solution(intArrayOf(0, 1, 1, 1))) //3
            println(PassingCars().solution(intArrayOf(1, 0, 0, 0))) //0
            println(PassingCars().solution(intArrayOf(0, 0, 1))) //2
            println(PassingCars().solution(intArrayOf(0, 1, 0))) //1
        }
    }
}