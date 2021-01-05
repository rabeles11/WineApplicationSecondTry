package com.example.wineapplication.ui.TypeOfWine

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.wineapplication.Data.Request
import com.example.wineapplication.MainActivity2
import com.example.wineapplication.R
import com.google.android.material.slider.Slider
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.uiThread
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class TypeOfWineFragment : Fragment() {
    companion object {
        const val COMPANION_INPUT_TEXT_WINE = "Input_text_wine"
    }


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_type_of_wine, container, false)
        val button = view.findViewById<Button>(R.id.appCompatButton)
        val edittext = view.findViewById<EditText>(R.id.plain_text_food_input)
        val maxprice = view.findViewById<Slider>(R.id.continuousSliderPrice)
        val minrating = view.findViewById<Slider>(R.id.continuousSliderRating)
        val NumberOfRecommendations = view.findViewById<Slider>(R.id.continuousSliderRecommondation)
        val loader = view.findViewById<ProgressBar>(R.id.progressBar)










        button.setOnClickListener { // Handler code here.
            //val SecondActivityRedirect = Intent(context, MainActivity2::class.java)
            Log.v("Values", edittext.text.toString())
            Log.v("Values", maxprice.value.toString())
            Log.v("Values", minrating.value.toString())
            Log.v("Values", NumberOfRecommendations.value.toString())

            val url = "https://api.spoonacular.com/food/wine/recommendation?apiKey=58e43f7fbc93427da2ecfd2520ca24cf&wine="+
                    edittext.text.toString().toLowerCase()+
                    "&number="+
                    NumberOfRecommendations.value.toString().toFloat().toInt().toString()+
                    "&maxPrice="+
                    maxprice.value.toString().toFloat().toInt().toString()+
                    "&minRating="+
                    minrating.value.toString()

            Log.v("URL", url)
            doAsync {

                val Json = Request(url).run()
                //val Json = Recipe.getRecipesFromURL(url)

                if(Json == "Chyba")
                {
                    uiThread { toast("Wine not found!!") }
                    loader.visibility = View.INVISIBLE
                    button.visibility = View.VISIBLE

                }
                else{
                    uiThread { toast("Request Performed") }
                    val SecondActivityRedirect = Intent(context, MainActivity2::class.java)
                    SecondActivityRedirect.putExtra("Json",Json)
                    SecondActivityRedirect.putExtra("History",edittext.text.toString())
                    startActivity(SecondActivityRedirect);
                }


            }
            button?.visibility = View.INVISIBLE
            loader.visibility = View.VISIBLE

        }
        return view
    }

    override fun onResume() {

        val loader = view?.findViewById<ProgressBar>(R.id.progressBar)
        loader?.visibility = View.INVISIBLE
        val button = view?.findViewById<Button>(R.id.appCompatButton)
        button?.visibility = View.VISIBLE
        super.onResume()
    }

}