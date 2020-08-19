package com.example.firstapplication

import android.os.Looper
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun onCreateTest() {
        Looper.prepare()
        val main = launchActivity<MainActivity>()
        val complete = main.fetchData().isCompleted
        var bar = main.progress_bar
        val visible = bar.isVisible

        assertEquals(true, complete)
        assertEquals(false, visible)
    }
}

