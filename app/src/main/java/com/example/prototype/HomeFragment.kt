package com.example.prototype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    fun currentFragment(
        ActionId: Int,
        characterNameKey: String,
        characterName: String,
        urlImgKey: String,
        ulrImgCharacter: String
    ) {
        findNavController().navigate(
            ActionId,
            bundleOf(
                characterNameKey to characterName,
                urlImgKey to ulrImgCharacter
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnSolaire: Button = view.findViewById(R.id.btnSolaire)
        val btnSiegmeyer: Button = view.findViewById(R.id.btnSiegmeyer)
        val btnExitApp: Button = view.findViewById(R.id.btnHomeExit)

        btnSolaire.setOnClickListener {
            currentFragment(
                R.id.action_homeFragment_to_firstFragment,
                CHARACTER1_NAME_KEY,
                getString(R.string.solaire),
                CHARACTER1_IMG_URL_KEY,
                CHARACTER1_IMG_URL
            )
        }

        btnSiegmeyer.setOnClickListener {
            currentFragment(
                R.id.action_homeFragment_to_secondFragment,
                CHARACTER2_NAME_KEY,
                getString(R.string.siegmeyer),
                CHARACTER2_IMG_URL_KEY,
                CHARACTER2_IMG_URL
            )
        }
        btnExitApp.setOnClickListener {
            activity?.onBackPressed();
        }

    }

    companion object {
        const val CHARACTER1_NAME_KEY = "nameCharacter_1"
        const val CHARACTER2_NAME_KEY = "nameCharacter_2"
        const val CHARACTER1_IMG_URL_KEY = "urlImgCharacter_1"
        const val CHARACTER2_IMG_URL_KEY = "urlImgCharacter_2"
        const val CHARACTER1_IMG_URL =
            "https://static.wikia.nocookie.net/darksouls/images/5/54/SolaireCA.jpg/revision/latest?cb=20130128234108"
        const val CHARACTER2_IMG_URL =
            "https://i.pinimg.com/736x/67/f8/03/67f80319318a06251d175124bc365026.jpg"
    }
}