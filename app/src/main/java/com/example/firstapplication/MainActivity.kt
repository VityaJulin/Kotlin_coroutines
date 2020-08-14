package com.example.firstapplication

import android.os.Bundle
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

    private fun fetchData(): Job = launch {
        val list = withContext(Dispatchers.IO) {
            Api.client.get<MutableList<PostCard>>(Api.url)
        }

        val listAdv = withContext(Dispatchers.IO) {
            Api.client.get<MutableList<PostCard>>(Api.urlAdv)
        }

        list.addAll(listAdv)
        list.shuffle()

        with(recycle_main) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = Adapter(list)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}