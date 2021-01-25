package com.example.portfolio

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*

class Fav : AppCompatActivity() {
    var adapter: Photos.ImgAdapter? = null
    var imgList = ArrayList<Item>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_fav)
        val gvPhotos = findViewById<GridView>(R.id.gv_photos)
        imgList.add(Item(R.drawable.fav1))
        imgList.add(Item(R.drawable.fav2))
        imgList.add(Item(R.drawable.fav3))
        imgList.add(Item(R.drawable.fav4))
        imgList.add(Item(R.drawable.fav5))
        imgList.add(Item(R.drawable.fav6))
        imgList.add(Item(R.drawable.fav7))
        imgList.add(Item(R.drawable.fav8))

        adapter = Photos.ImgAdapter(this, imgList)

        gvPhotos.adapter = adapter
        gvPhotos.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val intent = Intent(this@Fav, ImageHolder::class.java)
            intent.putExtra("Img", imgList[position].image)
            startActivity(intent)
        }

        val back = findViewById<ImageButton>(R.id.btn_back)


        back.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                finish()
                overridePendingTransition(R.anim.slide_in_left,
                        R.anim.slide_out_right);
                return true
            }
        })
    }

    class ImgAdapter : BaseAdapter {
        var imgList = ArrayList<Item>()
        var context: Context? = null

        constructor(context: Context, imgList: ArrayList<Item>) : super() {
            this.context = context
            this.imgList = imgList
        }

        override fun getCount(): Int {
            return imgList.size
        }

        override fun getItem(position: Int): Any {
            return imgList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val img = this.imgList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var imgView = inflator.inflate(R.layout.photo_entry, null)
            var imgPhoto = imgView.findViewById<ImageView>(R.id.imgPhoto)
            imgPhoto.setImageResource(img.image!!)

            return imgView
        }
    }
}