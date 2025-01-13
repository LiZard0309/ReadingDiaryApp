package com.example.readingdiary

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "onCreate()")

    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "onPause()")
    }

    override fun onStop(){
        super.onStop()
        Log.e("MainActivity", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity", "onDestroy()")
    }
}