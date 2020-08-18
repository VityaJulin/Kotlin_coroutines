package com.example.firstapplication

import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Test

import org.junit.Assert.*

class MainActivityTest {


    @Test
    fun onCreateTest() {
        val main = MainActivity()
        val complite = main.fetchData().isCompleted
        val visible = main.progress_bar.isVisible

        assertEquals(false, complite == visible)
    }
}