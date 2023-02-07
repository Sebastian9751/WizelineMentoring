package com.example.prototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.prototype.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val toolbar: Toolbar = findViewById(R.id.ToolbarMain)
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)
        val background: ImageView = findViewById(R.id.backgroundImg)
        Glide.with(this).load(BACKGROUND_URL_IMAGE).into(background)
    }

    companion object {
        const val BACKGROUND_URL_IMAGE = "https://i.gifer.com/neu.gif"
    }

}