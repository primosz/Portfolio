package com.example.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView

class ImageHolder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_image_holder)
        val imgId = intent.getIntExtra("Img", R.drawable.a)
        val imgHolder = findViewById<ImageView>(R.id.iv_holder)
        val back = findViewById<ImageButton>(R.id.btn_back)

        imgHolder.setImageResource(imgId)


        back.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                finish()
                overridePendingTransition(R.anim.slide_in_left,
                    R.anim.slide_out_right);
                return true
            }
        })
    }
}