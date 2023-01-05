package com.example.prototype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.prototype.MainActivity.Companion.CHARACTER1_IMG_URL
import com.example.prototype.MainActivity.Companion.CHARACTER1_NAME_KEY

class FirstFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textCharacter1: TextView = view.findViewById(R.id.textSolaire)
        val characterImg: ImageView = view.findViewById(R.id.imgSolaire)
        arguments?.let {
            textCharacter1.text = it.getString(CHARACTER1_NAME_KEY)
            Glide.with(this).load(CHARACTER1_IMG_URL).into(characterImg)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
}