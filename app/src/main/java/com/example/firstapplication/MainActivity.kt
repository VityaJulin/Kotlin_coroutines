package com.example.firstapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.ktor.client.request.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import net.danlew.android.joda.JodaTimeAndroid

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JodaTimeAndroid.init(this)

        fetchData()
    }

    fun fetchData(): Job = launch {
        val list = withContext(Dispatchers.IO) {
            Api.client.get<MutableList<PostCard>>(Api.url)
        }

        val listAdv = withContext(Dispatchers.IO) {
            Api.client.get<MutableList<PostCard>>(Api.urlAdv)
        }
        val mixer = PostsMixer()
        var listPostAndAdv = mixer.mixLists(list, listAdv)

        with(recycle_main) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = Adapter(listPostAndAdv)
        }
        if (fetchData().isCompleted) {
            progress_bar.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

}