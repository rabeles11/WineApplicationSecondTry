package com.example.wineapplication.ui.AboutUs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.wineapplication.MainActivity2
import com.example.wineapplication.R
import com.squareup.picasso.Picasso


class AboutUsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_aboutus, container, false)


        val UTBImage = view.findViewById<ImageView>(R.id.imageViewUTB)

        Picasso.get()
                .load("https://lh3.googleusercontent.com/proxy/YRFSuzH1e2yKvPTOsOpn5vopM2sjNNbdiZUCWnlJsc4YsqmEM6MCR4yrLH_LBPuiYlFnkGMk_BIkLQYKMu5juHkI")
                .fit().placeholder(R.mipmap.ic_launcher)
                .into(UTBImage)
        return view
    }


}