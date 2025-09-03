package com.example.vibestream

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splash)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //play
        val play: Button = findViewById(R.id.button3)
        val play1: ImageView = findViewById(R.id.imageView5)
        val play2: ImageView = findViewById(R.id.imageView23)

        play.setOnClickListener {
            // Navigate to player
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }
        play1.setOnClickListener {
            // Navigate to player
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }
        play2.setOnClickListener {
            // Navigate to player
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }



        //trending
        val newButton: Button = findViewById(R.id.newbtn)

        newButton.setOnClickListener {
            // Navigate to Trending
            val intent = Intent(this, TrendActivity::class.java)
            startActivity(intent)
        }

        //sign
        val sign: Button = findViewById(R.id.button8)

        sign.setOnClickListener {
            // Navigate to Trending
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }

        //Search
        val searchImage: ImageView = findViewById(R.id.searchimg)

        searchImage.setOnClickListener {
            // Navigate to Search
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        //log
        val log: ImageView = findViewById(R.id.imageView3)

        log.setOnClickListener {
            // Navigate to Search
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        //navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    true
                }
                R.id.trend -> {
                    startActivity(Intent(this, TrendActivity::class.java))
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