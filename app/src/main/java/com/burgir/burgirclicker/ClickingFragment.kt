package com.burgir.burgirclicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ClickingFragment : Fragment() {

    // Creating the variables needed in this activity
    val WALLET_KEY = "wallet"
    lateinit var burgirButton: ImageButton
    lateinit var storeButton: ImageButton
    lateinit var careerButton: ImageButton
    lateinit var optionsButton: ImageButton
    lateinit var walletTextView: TextView


    var wallet = 0
    var clickMultiplier = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_clicking, container, false)


        // getting references to View objects
        burgirButton    = view.findViewById<ImageButton>(R.id.BurgirButton)
        storeButton     = view.findViewById<ImageButton>(R.id.StoreButton)
        careerButton    = view.findViewById<ImageButton>(R.id.CareerButton)
        optionsButton   = view.findViewById<ImageButton>(R.id.OptionsButton)
        walletTextView  = view.findViewById<TextView>(R.id.walletTextView)
        walletTextView.text = wallet.toString()  // immediately update the value displayed

        // setting the onClickListeners for all buttons
        burgirButton.setOnClickListener{clickBurgirButton()}
        storeButton.setOnClickListener{clickStoreButton()}
        careerButton.setOnClickListener{clickCareerButton()}
        optionsButton.setOnClickListener{clickOptionsButton()}

        // retrieving data from the Bundle if it's not null
        if (savedInstanceState != null) {
            wallet = savedInstanceState.getInt(WALLET_KEY)
            walletTextView.text = wallet.toString()
        }

        return view
    }



    fun clickBurgirButton() {
        wallet += clickMultiplier
        walletTextView.text = wallet.toString()
    }

    fun clickStoreButton() {
        view?.findNavController()?.navigate(R.id.action_clickingFragment_to_storeFragment)
    }

    fun clickCareerButton() {
        view?.findNavController()?.navigate(R.id.action_clickingFragment_to_careerFragment)
    }

    fun clickOptionsButton() {
        view?.findNavController()?.navigate(R.id.action_clickingFragment_to_optionsFragment)
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
    savedInstanceState.putInt(WALLET_KEY, wallet)
    super.onSaveInstanceState(savedInstanceState)
    }

}