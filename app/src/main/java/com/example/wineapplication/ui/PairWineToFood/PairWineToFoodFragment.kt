package com.example.wineapplication.ui.PairWineToFood

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.wineapplication.Data.Request
import com.example.wineapplication.MainActivity2
import com.example.wineapplication.PairingForWineActivity
import com.example.wineapplication.R
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.uiThread

class PairWineToFoodFragment : Fragment(R.layout.fragment_pair_wine_to_food) {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater.inflate(R.layout.fragment_pair_wine_to_food, container, false)
        val button = view.findViewById<Button>(R.id.buttonFood)
        val edittext = view.findViewById<EditText>(R.id.plain_text_food_input)


        button.setOnClickListener { // Handler code here.
            val url = "https://api.spoonacular.com/food/wine/dishes?apiKey=58e43f7fbc93427da2ecfd2520ca24cf&wine="+
                    edittext.text.toString().toLowerCase()


            Log.v("URL", url)
            doAsync {
                val Json = Request(url).run()

                if(Json == "Chyba")
                {
                    uiThread { toast("Wine not found!!") }
                }
                else{
                    uiThread { toast("Request Performed") }
                    val PairWineToFoodActivityRedirect = Intent(context, PairingForWineActivity::class.java)
                    PairWineToFoodActivityRedirect.putExtra("Json",Json)
                    startActivity(PairWineToFoodActivityRedirect);
                }
            }


        }



        return view
    }
}