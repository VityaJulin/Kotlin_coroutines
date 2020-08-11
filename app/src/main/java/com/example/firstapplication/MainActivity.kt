package com.example.firstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.ktor.client.request.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import net.danlew.android.joda.JodaTimeAndroid
import org.joda.time.LocalDate
import kotlin.coroutines.CoroutineContext

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