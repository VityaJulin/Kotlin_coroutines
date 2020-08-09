package com.example.firstapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.danlew.android.joda.JodaTimeAndroid
import org.joda.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JodaTimeAndroid.init(this)

        with(recycle_main) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = Adapter(list)
        }
    }

    private val list = listOf(
        PostCard(
            "Username1",
            LocalDate(),
            "first post in our network",
            postType = PostType.EVENT
        ),
        PostCard(
            "Username2",
            LocalDate(),
            "second post in our network",
            postType = PostType.YOUTUBE_VIDEO
        ),
        PostCard(
            "Username3",
            LocalDate(),
            "third post in our network",
            postType = PostType.REPOST
        )

    )
}