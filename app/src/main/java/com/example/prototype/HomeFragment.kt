package com.example.prototype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.prototype.databinding.FragmentHomeBinding
import com.example.prototype.utils.Constanst.CHARACTER1_IMG_URL
import com.example.prototype.utils.Constanst.CHARACTER1_IMG_URL_KEY
import com.example.prototype.utils.Constanst.CHARACTER1_NAME_KEY
import com.example.prototype.utils.Constanst.CHARACTER2_IMG_URL
import com.example.prototype.utils.Constanst.CHARACTER2_IMG_URL_KEY
import com.example.prototype.utils.Constanst.CHARACTER2_NAME_KEY


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false )
        return binding.root
    }

    private fun currentFragment(
        actionId: Int,
        characterNameKey: String,
        characterName: String,
        urlImgKey: String,
        ulrImgCharacter: String
    ) {
        findNavController().navigate(
            actionId,
            bundleOf(
                characterNameKey to characterName,
                urlImgKey to ulrImgCharacter
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSolaire.setOnClickListener {
            currentFragment(
                R.id.action_homeFragment_to_firstFragment,
                CHARACTER1_NAME_KEY,
                getString(R.string.solaire),
                CHARACTER1_IMG_URL_KEY,
                CHARACTER1_IMG_URL
            )
        }

        binding.btnSolaire.setOnClickListener {
            currentFragment(
                R.id.action_homeFragment_to_secondFragment,
                CHARACTER2_NAME_KEY,
                getString(R.string.siegmeyer),
                CHARACTER2_IMG_URL_KEY,
                CHARACTER2_IMG_URL
            )
        }
        binding.btnHomeExit.setOnClickListener {
            activity?.onBackPressed();
        }

    }


}