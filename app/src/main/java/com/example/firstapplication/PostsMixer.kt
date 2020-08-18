package com.example.firstapplication

import kotlin.math.min

class PostsMixer {
    fun mixLists(
        one: MutableList<PostCard>,
        two: MutableList<PostCard>
    ): MutableList<PostCard> {
        val oneSize = one.size
        val twoSize = two.size
        val intervalSize = 3
        var listsArr = one.subList(0, min(oneSize, intervalSize)).toMutableList()
        var j = 0

        for (i in intervalSize..oneSize step intervalSize) {
            listsArr.addAll(two.subList(j, min(twoSize, j + 1)))
            j += 1
            listsArr.addAll(one.subList(i, min(oneSize, i + intervalSize)))
        }

        return listsArr
    }
}