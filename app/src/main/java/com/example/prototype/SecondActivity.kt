package com.example.prototype

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SecondActivity : AppCompatActivity() {
    private lateinit var txt: TextView
    private lateinit var btn: Button
    private lateinit var img: ImageView

    private fun chargeImage(url: String) {
        Glide.with(this)
            .load(url)
            .into(img)
    }

    private fun initViews() {
        txt = findViewById(R.id.texto_body)
        btn = findViewById(R.id.boton_s2)
        img = findViewById(R.id.image)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val bundle = intent.extras
        val idItem = bundle?.getInt(MainActivity.ID_KEY)
        initViews()
        if (idItem == 1) {
            txt.setText(R.string.siegmeyer)
            chargeImage(URL_1)
        } else if (idItem == 2) {
            txt.setText(R.string.solaire)
            chargeImage(URL_2)
        }
        btn.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val URL_1 = "https://i.pinimg.com/736x/67/f8/03/67f80319318a06251d175124bc365026.jpg"
        const val URL_2 =
            "https://static.wikia.nocookie.net/darksouls/images/5/54/SolaireCA.jpg/revision/latest?cb=20130128234108"
    }
}