package com.example.firstapplication

import org.joda.time.LocalDate

class PostCard(
    val username: String,
    val date: LocalDate,
    val post: String,
    val liked: Boolean = false,
    val commented: Boolean = false,
    val shared: Boolean = false
) {

}