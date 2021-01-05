package com.example.wineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONObject



class PairingForWineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pairing_for_wine)


        val bundle: Bundle? = intent.extras
        val Json = bundle?.get("Json")
        val json = JSONObject(Json.toString())

        val textrec = json.get("text")
        val PairedFoods = json.getJSONArray("pairings")
        Log.v("JsonTry",PairedFoods.getString(0))
        Log.v("JsonTry",textrec.toString())

        val FisrtFood = findViewById<TextView>(R.id.Food1)
        val SecondFood = findViewById<TextView>(R.id.Food2)
        val ThirdFood = findViewById<TextView>(R.id.Food3)
        val RecomendText = findViewById<TextView>(R.id.RecomendText)

        FisrtFood.setText(PairedFoods.getString(0))
        ThirdFood.setText(PairedFoods.getString(1))
        SecondFood.setText(PairedFoods.getString(2))
        RecomendText.setText(textrec.toString())
    }
}