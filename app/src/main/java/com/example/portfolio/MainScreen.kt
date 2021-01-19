package com.example.portfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val btn_aboutme = findViewById<Button>(R.id.btn_about)
        val btn_hobby = findViewById<Button>(R.id.btn_hobby)
        val btn_photos = findViewById<Button>(R.id.btn_photos)
        val btn_fav = findViewById<Button>(R.id.btn_fav)





        btn_aboutme.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                btn_aboutme.isEnabled = false
                val intent = Intent(this@MainScreen, AboutMe::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_left,
                    R.anim.slide_out_right);

                return true
            }
        })

        btn_hobby.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                btn_hobby.isEnabled = false
                val intent = Intent(this@MainScreen, Hobby::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right,
                    R.anim.slide_out_left);

                return true
            }
        })
    }



    override fun onResume() {
        super.onResume()
        val btn_aboutme = findViewById<Button>(R.id.btn_about)
        btn_aboutme.isEnabled = true
        val btn_hobby = findViewById<Button>(R.id.btn_hobby)
        btn_hobby.isEnabled = true
    }
}