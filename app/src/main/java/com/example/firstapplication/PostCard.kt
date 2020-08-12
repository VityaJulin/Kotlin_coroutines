package com.example.firstapplication

import org.joda.time.LocalDate

class PostCard(
    val username: String,
    val date: LocalDate = LocalDate(),
    val post: String,
    var liked: Boolean = false,
    var commented: Boolean = false,
    var shared: Boolean = false,
    var likeCounts: Int = 0,
    var commentCounts: Int = 0,
    var shareCounts: Int = 0,
    val postType: PostType? = null
) {

}