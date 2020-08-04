package com.example.firstapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.post_card_view.*
import net.danlew.android.joda.JodaTimeAndroid
import org.joda.time.LocalDate
import org.joda.time.Period

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JodaTimeAndroid.init(this)
        initViews()

        like_btn.setOnClickListener {
            post.liked = !post.liked

            if (post.liked) {
                like_btn.setImageResource(R.drawable.ic_baseline_favorite_24_f10f0a)
                like_counts_txt.text = "1"
                like_counts_txt.visibility = View.VISIBLE
            } else {
                like_btn.setImageResource(R.drawable.ic_baseline_favorite_24_808080)
                like_counts_txt.text = "0"
                like_counts_txt.visibility = View.INVISIBLE
            }
        }

        comment_btn.setOnClickListener {
            post.commented = !post.commented

            if (post.commented) {
                comments_counts_txt.text = "1"
                comments_counts_txt.visibility = View.VISIBLE
            } else {
                comments_counts_txt.text = "0"
                comments_counts_txt.visibility = View.INVISIBLE
            }
        }

        share_btn.setOnClickListener {
            post.shared = !post.shared

            if (post.shared) {
                share_counts_txt.text = "1"
                share_counts_txt.visibility = View.VISIBLE
            } else {
                share_counts_txt.text = "0"
                share_counts_txt.visibility = View.INVISIBLE
            }
        }

        location_btn.setOnClickListener {
            val intentUri = Uri.parse(
                if (post.coordinate != "") {
                    "geo:${post.coordinate}"
                } else {
                    "geo:0,0?q=${post.address}"
                }
            )
            val mapIntent = Intent(Intent.ACTION_VIEW, intentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }


    private val post = PostCard("Username", LocalDate(), "first post in our network", true)

    private fun initViews() {
        username_txt.text = post.username
        post_txt.text = post.post
        date_txt.text = getTimePeriod(post)

        if (post.liked) {
            like_btn.setImageResource(R.drawable.ic_baseline_favorite_24_f10f0a)
            like_counts_txt.text = "1"
            like_counts_txt.visibility = View.VISIBLE
        }

        if (post.commented) {
            comments_counts_txt.text = "1"
            comments_counts_txt.visibility = View.VISIBLE
        }

        if (post.shared) {
            share_counts_txt.text = "1"
            share_counts_txt.visibility = View.VISIBLE
        }
    }

    private fun getTimePeriod(post: PostCard): String {
        val currentDate = LocalDate()
        val postDate = post.date
        val period = Period(postDate, currentDate)

        return "hour " + period.hours + " minutes " + period.minutes + " ago"
    }
}