package com.example.prototype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.prototype.MainActivity.Companion.CHARACTER2_IMG_URL
import com.example.prototype.MainActivity.Companion.CHARACTER2_NAME_KEY


class SecondFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textCharacter1 : TextView = view.findViewById(R.id.textSiegmeyer)
        val characterImg: ImageView = view.findViewById(R.id.imgSiegmeyer)
        arguments?.let {
            textCharacter1.text = it.getString(CHARACTER2_NAME_KEY)
            Glide.with(this).load(CHARACTER2_IMG_URL).into(characterImg)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}