package com.example.firstapplication

import com.google.gson.Gson
import java.io.File

class Serializer {
    init {
        val posts = listOf(
            PostCard(
                username = "Username1",
                post = "First post in our network!",
                postType = PostType.EVENT
            ),
            PostCard(
                username = "Username2",
                post = "Second post in our network!",
                postType = PostType.YOUTUBE_VIDEO
            ),
            PostCard(
                username = "Username3",
                post = "Third post in our network!"
            ),
            PostCard(
                username = "Username4",
                post = "Fourth post in our network!"
            )
        )

        val advertising = listOf(
            PostCard(
                username = "Advertising1",
                post = "Advertising post in our network",
                postType = PostType.EVENT
            )
        )

        val gson = Gson()
        File("./posts.json").writeText(gson.toJson(posts))
        File("./advertising.json").writeText(gson.toJson(advertising))
    }
}