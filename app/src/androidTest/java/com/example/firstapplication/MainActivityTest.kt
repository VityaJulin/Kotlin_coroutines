package com.example.firstapplication

import android.os.Looper
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Test

import org.junit.Assert.*

class MainActivityTest {


    @Test
    fun onCreateTest() {
        Looper.prepare()
        val main = MainActivity()
        val complete = main.fetchData().isCompleted
        var bar = main.progress_bar
        val visible = bar.isVisible

        assertEquals(true, complete)
        assertEquals(false, visible)
    }
}