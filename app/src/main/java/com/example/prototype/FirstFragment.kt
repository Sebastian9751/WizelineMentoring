package com.example.prototype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class FirstFragment : Fragment() {
    private var name: String? = null
    private var url: String? = null

    private fun chargeImage(url: String?, img: ImageView) {
        Glide.with(this)
            .load(url)
            .into(img)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val texto: TextView = view.findViewById(R.id.textF1)
        val image: ImageView = view.findViewById(R.id.image)
        texto.setText("")
        arguments?.let {
            name = it.getString(NAME_KEY)
            url = it.getString(NAME_KEY_2)
            texto.setText(name.orEmpty())
            chargeImage(url, image)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    companion object {
        const val NAME_KEY = "k1"
        const val NAME_KEY_2 = "k2"
    }
}