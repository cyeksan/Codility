package com.example.codility

class EquiLeader {
    fun solution(A: IntArray) : Int {
        // special case
        // special case
        if (A.isEmpty()) return 0

        // The key point:
        // Only the "leader of the whole array" can have an "equi leader"
        // Assume a value Y is "not" the leader of the whole array.
        // Can value Y have an equi leader?
        // The answer is NO.

        // Based on this condition, to solve this problem,
        // 1. we first find the leader of the whole array.
        // 2. after finding a leader (if any),
        //    we then scan the whole array again.

        // 1. find the leader of an array
        // ---> we use "hashMap"

        val map: MutableMap<Int, Int> = HashMap()
        // map(key, value) ---> map(number, count)
        for (i in A.indices) {
            if (!map.containsKey(A[i])) {
                map[A[i]] = 1
            } else {
                map[A[i]] = map[A[i]]!! + 1
            }
        }

        // find the max_Value and max_Count
        var maxValue = A[0]
        var maxCount = 1
        // important: Using "for( int j: map.keySet() )"
        for (j in map.keys) {
            val curCount = map[j]!!
            if (curCount > maxCount) {
                maxCount = curCount
                maxValue = j
            }
        }

        // check "if there is a leader"
        val leaderValue: Int
        val leaderCount: Int
        if (maxCount > 0.5 * A.size) {
            leaderValue = maxValue
            leaderCount = maxCount
        } else {
            return 0 // no leader ---> no equi leaders
        }
        // note: cannot use (1/2) * (A.length)
        // This is because (1/2) will be "zero"
        // Instead, we can use (0.5) * (A.length) (be careful)

        // 2. scan the whole array again
        var numEquiLeaders = 0 // number of equi leaders

        var leftLeaderCount = 0 // number of leaders in left side

        // scan the array
        for (i in A.indices) {

            // find a leader (in left side)
            if (A[i] == leaderValue) {
                leftLeaderCount++
            }

            // if the leader is "a leader in left side" (more than half)
            if (leftLeaderCount > 0.5 * (i + 1)) {
                // then, check right side
                val right_Leader_Count = leaderCount - leftLeaderCount
                // if the leader is "a leader in right side" (more than half)
                if (right_Leader_Count > 0.5 * (A.size - i - 1)) {
                    numEquiLeaders++ // leader in both sides (then, equi leaders++)
                }
            }
        }
        // return number of equi leaders
        return numEquiLeaders
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(EquiLeader().solution(intArrayOf(4,3,4,4,4,2))) //2
        }
    }
}