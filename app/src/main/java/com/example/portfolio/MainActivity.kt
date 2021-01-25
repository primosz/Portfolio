package com.example.portfolio

import android.content.Intent
import android.net.Uri
import android.net.Uri.parse
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var isSkipped = false;
    override fun onCreate(savedInstanceState: Bundle?) {

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        val params = videoView.layoutParams as LinearLayout.LayoutParams
        params.width = metrics.widthPixels
        videoView.layoutParams = params
                //specify the location of media file
        val uri: Uri = parse("android.resource://" + getPackageName() + "/" + R.raw.animation2)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
        Handler().postDelayed({
            if (!isSkipped) {
                val intent = Intent(this@MainActivity, MainScreen::class.java)
                startActivity(intent)
                finish()
            }
        }, 6000)


        videoView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                isSkipped = true
                Toast.makeText(this@MainActivity, "Skipped", Toast.LENGTH_LONG).show()
                val intent = Intent(this@MainActivity, MainScreen::class.java)
                startActivity(intent)
                finish()
                return true
            }
        })
    }
}