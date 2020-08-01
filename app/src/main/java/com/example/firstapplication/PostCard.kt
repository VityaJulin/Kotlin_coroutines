package com.example.firstapplication

import org.joda.time.LocalDate

class PostCard(
    val username: String,
    val date: LocalDate,
    var post: String,
    var liked: Boolean = false,
    var commented: Boolean = false,
    var shared: Boolean = false
) {

}