package com.example.firstapplication

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.danlew.android.joda.JodaTimeAndroid
import org.joda.time.LocalDate
import org.joda.time.Period
import org.joda.time.PeriodType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JodaTimeAndroid.init(this)
        initViews()
    }

    private val post = PostCard("Username", LocalDate(), "first post in our network", true)

    private fun initViews() {
        val nameTv = findViewById<TextView>(R.id.username_txt)
        val dateTv = findViewById<TextView>(R.id.date_txt)
        val postedTv = findViewById<TextView>(R.id.post_txt)
        val likeBtn = findViewById<ImageButton>(R.id.like_btn)
        val likeCountTv = findViewById<TextView>(R.id.like_counts_txt)
        val commentBtn = findViewById<ImageButton>(R.id.comment_btn)
        val commentsCountTv = findViewById<TextView>(R.id.comments_counts_txt)
        val shareBtn = findViewById<ImageButton>(R.id.share_btn)
        val shareCountsTv = findViewById<TextView>(R.id.share_counts_txt)

        nameTv.text = post.username
        postedTv.text = post.post
        dateTv.text = getTimePeriod(post)

        if (post.liked) {
            likeBtn.setImageResource(R.drawable.ic_baseline_favorite_24_f10f0a)
            likeCountTv.text = "1"
            likeCountTv.visibility = View.VISIBLE
        }

        if (post.commented) {
            commentsCountTv.text = "1"
            commentsCountTv.visibility = View.VISIBLE
        }

        if (post.shared) {
            shareCountsTv.text = "1"
            shareCountsTv.visibility = View.VISIBLE
        }
    }

    private fun getTimePeriod(post: PostCard): String{
        val currentDate = LocalDate()
        val postDate= post.date
        val period = Period(postDate, currentDate)

        return "hour " + period.hours + " minutes " + period.minutes +  " ago"
    }
}