package com.example.prototype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

class SecondFragment : Fragment() {
    private val arguments: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textCharacter1: TextView = view.findViewById(R.id.textSiegmeyer)
        val characterImg: ImageView = view.findViewById(R.id.imgSiegmeyer)
        val btnGoHome: Button = view.findViewById((R.id.SecondFragmentGoHome))
        arguments?.let {
            textCharacter1.text = arguments.nameCharacter2
            Glide.with(this).load(arguments.urlImgCharacter2).into(characterImg)
        }
        btnGoHome.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}