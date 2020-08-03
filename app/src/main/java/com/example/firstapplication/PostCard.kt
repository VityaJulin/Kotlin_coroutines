package com.example.firstapplication

import android.net.Uri
import org.joda.time.LocalDate

class PostCard(
    val username: String,
    val date: LocalDate,
    val post: String,
    var liked: Boolean = false,
    var commented: Boolean = false,
    var shared: Boolean = false,
    var address: String = "Moscow Russia",
    var coordinate: Uri? = null
) {

}