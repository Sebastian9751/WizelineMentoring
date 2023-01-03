package com.example.prototype


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.bumptech.glide.Glide
import com.example.prototype.FirstFragment.Companion.NAME_KEY
import com.example.prototype.FirstFragment.Companion.NAME_KEY_2

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var btn2: Button
    private lateinit var img: ImageView
    private var sup = supportFragmentManager;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        img = findViewById(R.id.imageView)
        Glide.with(this).load(URL_3).into(img)

        fun setFragment(dato: String, url: String) {
            if (savedInstanceState == null) {
                val bundle = bundleOf(NAME_KEY to dato, NAME_KEY_2 to url)
                sup.beginTransaction().apply {
                    replace(R.id.fragmentContainer, FirstFragment()).commit()

                    sup.commit {
                        setReorderingAllowed(true)
                        add<FirstFragment>(R.id.fragmentContainer, args = bundle)
                    }

                }
            }
        }

        btn.setOnClickListener() {
            setFragment(DATA_1, URL_1)
            btn.visibility= View.INVISIBLE
            btn2.visibility= View.VISIBLE
        }
        btn2.setOnClickListener() {
            btn2.visibility= View.INVISIBLE
            btn.visibility= View.VISIBLE
            setFragment(DATA_2, URL_2)
        }
    }

    companion object {
        const val DATA_1 = "Siegmeyer"
        const val DATA_2 = "Solaire"
        const val URL_1 = "https://i.pinimg.com/736x/67/f8/03/67f80319318a06251d175124bc365026.jpg"
        const val URL_2 =
            "https://static.wikia.nocookie.net/darksouls/images/5/54/SolaireCA.jpg/revision/latest?cb=20130128234108"
        const val URL_3 =
            "https://thumbs.gfycat.com/AnguishedBiodegradableJumpingbean-size_restricted.gif"
    }
}