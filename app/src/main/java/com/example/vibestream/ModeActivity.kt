package com.example.vibestream

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mode)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainmode)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //back
        val backImage: ImageView = findViewById(R.id.back)

        backImage.setOnClickListener {
            finish()
        }

        //play
        val play: ImageView = findViewById(R.id.imageView20)
        val play2: ImageView = findViewById(R.id.imageView21)
        val play3: ImageView = findViewById(R.id.imageView24)
        val play4: ImageView = findViewById(R.id.imageView25)

        play.setOnClickListener {
            // Navigate to play
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }
        play2.setOnClickListener {
            // Navigate to play
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }
        play3.setOnClickListener {
            // Navigate to play
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }
        play4.setOnClickListener {
            // Navigate to play
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }


        //navigation

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.postDelayed({
            bottomNav.selectedItemId = R.id.mood
        }, 10)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.trend -> {
                    startActivity(Intent(this, TrendActivity::class.java))
                    true
                }
                R.id.mood -> {
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