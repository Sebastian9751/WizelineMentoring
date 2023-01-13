package com.example.prototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val background: ImageView = findViewById(R.id.backgroundImg)
        Glide.with(this).load(BACKGROUND_URL).into(background)
    }

    companion object {
        const val BACKGROUND_URL = "https://i.gifer.com/neu.gif"
    }

}