package com.example.prototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var character1Btn: Button
    private lateinit var character2Btn: Button
    private fun currentFragment(
        fragmentToChange: Fragment,
        characterNameKey: String,
        characterName: String
    ) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer,
                fragmentToChange.apply {
                    arguments = bundleOf(
                        characterNameKey to characterName,
                    )
                }
            ).commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val background: ImageView = findViewById(R.id.backgroundImg)
        character1Btn = findViewById(R.id.btnSolaire)
        character2Btn = findViewById(R.id.btnSiegmeyer)
        Glide.with(this).load(BACKGROUND_URL).into(background)

        character1Btn.setOnClickListener {
            currentFragment(FirstFragment(), CHARACTER1_NAME_KEY, getString(R.string.solaire))
        }
        character2Btn.setOnClickListener {
            currentFragment(SecondFragment(), CHARACTER2_NAME_KEY, getString(R.string.siegmeyer))
        }
    }

    companion object {
        const val CHARACTER1_NAME_KEY = "character_name1"
        const val CHARACTER2_NAME_KEY = "character_name2"
        const val BACKGROUND_URL =
            "https://thumbs.gfycat.com/AnguishedBiodegradableJumpingbean-size_restricted.gif"
        const val CHARACTER1_IMG_URL =
            "https://static.wikia.nocookie.net/darksouls/images/5/54/SolaireCA.jpg/revision/latest?cb=20130128234108"
        const val CHARACTER2_IMG_URL =
            "https://i.pinimg.com/736x/67/f8/03/67f80319318a06251d175124bc365026.jpg"
    }
}