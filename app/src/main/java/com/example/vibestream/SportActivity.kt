package com.example.vibestream

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class SportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sport)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sport)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets}

        //play
        val play: ImageView = findViewById(R.id.imageView28)
        val play2: ImageView = findViewById(R.id.imageView29)
        val play3: ImageView = findViewById(R.id.imageView30)

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

        //back
        val backImage: ImageView = findViewById(R.id.back)

        backImage.setOnClickListener {
            finish()
        }


        //navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNav.postDelayed({
            bottomNav.selectedItemId = R.id.sport
        }, 10)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.trend -> {
                    startActivity(Intent(this, TrendActivity::class.java))
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