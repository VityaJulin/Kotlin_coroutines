package com.example.firstapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.ktor.client.request.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import net.danlew.android.joda.JodaTimeAndroid
import kotlin.math.min

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

        var listPostAndAdv = mixLists(list, listAdv)

        with(recycle_main) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = Adapter(listPostAndAdv)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

    private fun mixLists(
        one: MutableList<PostCard>,
        two: MutableList<PostCard>
    ): MutableList<PostCard> {
        val oneSize = one.size
        val twoSize = two.size
        val intervalSize = 3
        var listsArr = one.subList(0, min(oneSize, intervalSize)).toMutableList()
        var j = 0

        for (i in intervalSize..oneSize step intervalSize) {
            listsArr.addAll(two.subList(j, min(twoSize, j + 1)))
            j += 1
            listsArr.addAll(one.subList(i, min(oneSize, i + intervalSize)))
        }

        return listsArr
    }
}