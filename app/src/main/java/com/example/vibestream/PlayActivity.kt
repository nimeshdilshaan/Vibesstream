package com.example.vibestream

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlayActivity : AppCompatActivity() {

    private lateinit var playBtn: Button
    private lateinit var prevBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var albumArt: ImageView
    private lateinit var songTitle: TextView
    private lateinit var songArtist: TextView

    private var mediaPlayer: MediaPlayer? = null
    private var currentSongIndex = 0

    //song details
    private val songs = listOf(
        Song("Next", "Artist 1", R.drawable.next_image, R.raw.next),
        Song("Hanthana", "Artist 2", R.drawable.hanthana_image, R.raw.hanthana),
        Song("Wikasitha", "Artist 3", R.drawable.wikasitha_image, R.raw.wikasitha)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)


        //navigation bar
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

        //player buttons

        playBtn = findViewById(R.id.playPause)
        prevBtn = findViewById(R.id.prev)
        nextBtn = findViewById(R.id.next)

        // second textview
        albumArt = findViewById(R.id.albumArt)
        songTitle = findViewById(R.id.songTitle)
        songArtist = findViewById(R.id.songTitle2)

        loadSong(currentSongIndex)

        playBtn.setOnClickListener {
            if (mediaPlayer != null) {

                //hide spectrum and play button
                val hiddenImage = findViewById<ImageView>(R.id.visualizer)
                hiddenImage.visibility = View.GONE

                if (mediaPlayer!!.isPlaying) {
                    mediaPlayer!!.pause()
                    playBtn.text = "▶"


                } else {

                    mediaPlayer!!.start()
                    playBtn.text = "II"

                    //visible image
                    val hiddenImage = findViewById<ImageView>(R.id.visualizer)
                    hiddenImage.visibility = View.VISIBLE
                }
            }
        }

        nextBtn.setOnClickListener { playNextSong() }
        prevBtn.setOnClickListener { playPrevSong() }

        //Home
        val Home: Button = findViewById(R.id.all2)

        Home.setOnClickListener {
            // Navigate to Home
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //trending
        val newButton: Button = findViewById(R.id.newbtn2)

        newButton.setOnClickListener {
            // Navigate to Trending
            val intent = Intent(this, TrendActivity::class.java)
            startActivity(intent)
        }

        //back
        val backImage: ImageView = findViewById(R.id.back4)

        backImage.setOnClickListener {
            finish()
        }




        // Favorite button
        val favorite: ImageView = findViewById(R.id.fav)
        var isFavorite = false // Track favorite state

        favorite.setOnClickListener {
            isFavorite = !isFavorite // Toggle favorite state

            if (isFavorite) {
                // Change icon when added to playlist
                favorite.setImageResource(R.drawable.baseline_check_circle_24)
                Toast.makeText(this, "This song Added to playlist", Toast.LENGTH_SHORT).show()
            } else {
                // Change icon when removed from playlist
                favorite.setImageResource(android.R.drawable.ic_menu_add)
                Toast.makeText(this, "This song Removed from playlist", Toast.LENGTH_SHORT).show()
            }
        }
    }






    private fun loadSong(index: Int) {
        val song = songs[index]
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, song.audioResId)
        albumArt.setImageResource(song.imageResId)
        songTitle.text = song.title
        songArtist.text = song.artist
        playBtn.text = "▶"
    }

    private fun playNextSong() {
        currentSongIndex = (currentSongIndex + 1) % songs.size
        loadSong(currentSongIndex)
        mediaPlayer!!.start()
        playBtn.text = "II"
        Toast.makeText(this, "Now Playing: ${songs[currentSongIndex].title}", Toast.LENGTH_SHORT).show()
    }

    private fun playPrevSong() {
        currentSongIndex = if (currentSongIndex - 1 < 0) songs.size - 1 else currentSongIndex - 1
        loadSong(currentSongIndex)
        mediaPlayer!!.start()
        playBtn.text = "II"
        Toast.makeText(this, "Now Playing: ${songs[currentSongIndex].title}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
