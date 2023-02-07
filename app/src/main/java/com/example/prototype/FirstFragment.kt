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
import com.example.prototype.HomeFragmentDirections.ActionHomeFragmentToFirstFragment
import com.example.prototype.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private var _binding:FragmentFirstBinding? =null
    private val binding get()= _binding!!
    private val arguments: FirstFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textCharacter1: TextView = view.findViewById(R.id.textSolaire)
        val characterImg: ImageView = view.findViewById(R.id.imgSolaire)
        val btnGoHome: Button = view.findViewById(R.id.FirstFragmentGoHome)
        arguments.let {
            textCharacter1.text = arguments.nameCharacter1
            Glide.with(this).load(arguments.urlImgCharacter1).into(characterImg)
        }
        btnGoHome.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
}