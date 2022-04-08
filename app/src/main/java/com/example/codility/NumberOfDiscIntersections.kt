package com.example.codility

class NumberOfDiscIntersections {
    fun solution(A: IntArray) : Int {
        val starts = mutableListOf<Int>()
        val ends = mutableListOf<Int>()
        for ((point, radius) in A.withIndex()) {
            starts.add(point - radius)
            ends.add(point + radius)
        }

        starts.sort()
        ends.sort()

        //every time a disc closes we add an intersection for every disc that has opened
        // since the last close
        var intersections = 0
        var iStart = 0
        for (iEnd in ends.indices) {
            while (iStart < starts.size && starts[iStart] <= ends[iEnd]) {
                iStart++
            }
            intersections += iStart - iEnd - 1

            // trap runaway monsters
            if (intersections > MAX_INTERSECTIONS)
            return -1
        }
        return intersections
    }
    companion object {
        const val MAX_INTERSECTIONS = 10000000
        @JvmStatic
        fun main(args: Array<String>){
            println(NumberOfDiscIntersections().solution(intArrayOf(1, 5, 2, 1, 4, 0))) //11
            println(NumberOfDiscIntersections().solution(intArrayOf(1, 1, 1))) //3

        }
    }
}