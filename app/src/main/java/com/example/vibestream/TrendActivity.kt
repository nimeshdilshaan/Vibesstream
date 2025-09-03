package com.example.vibestream

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class TrendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trend)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.trendmain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //back
        val backImage: ImageView = findViewById(R.id.back)

        backImage.setOnClickListener {
            finish()
        }

        //navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNav.postDelayed({
            bottomNav.selectedItemId = R.id.trend
        }, 10)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.trend -> {
                    true
                }
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.mood -> {
                    startActivity(Intent(this, ModeActivity::class.java))
                    true
                }
                R.id.sport -> {
                    startActivity(Intent(this, SportActivity::class.java))
                    true
                }
                R.id.profile -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}