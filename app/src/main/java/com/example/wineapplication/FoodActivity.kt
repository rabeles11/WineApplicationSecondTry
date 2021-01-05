package com.example.wineapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.alltherecipes.TypeOfFood
import com.squareup.picasso.Picasso
import org.json.JSONObject
import org.w3c.dom.Text

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val bundle: Bundle? = intent.extras
        val Json = bundle?.get("Json")
        val Foods = TypeOfFood.ParseJsonToList(Json as String,this)
        val json = JSONObject(Json)
        val textrec = json.get("pairingText")
        val PairedWines = json.getJSONArray("pairedWines")
        Log.v("JsonTry",PairedWines.getString(0))
        Log.v("JsonTry",textrec.toString())


        val FisrtWine = findViewById<TextView>(R.id.WineRec1)
        val SecondWine = findViewById<TextView>(R.id.WineRec2)
        val ThirdWine = findViewById<TextView>(R.id.WineRec3)
        val TextViewName = findViewById<TextView>(R.id.WineName)
        val TextViewPrice = findViewById<TextView>(R.id.winePrice)
        val thumbnailImageView = findViewById<ImageView>(R.id.imageViewWineShow)
        val buttonClickBuy = findViewById<Button>(R.id.buttonSell)
        //val textViewRec = findViewById<TextView>(R.id.textViewRec)
        FisrtWine.setText(PairedWines.getString(0))
        ThirdWine.setText(PairedWines.getString(1))
        SecondWine.setText(PairedWines.getString(2))
        TextViewName.setText(Foods[0].title)
        TextViewPrice.setText("Price: "+Foods[0].price)

        //textViewRec.setText(textrec.toString())
        print(Foods[0].imageUrl)
        Log.v("Img",Foods[0].imageUrl)
        Picasso.get().load(Foods[0].imageUrl).fit().placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

        buttonClickBuy.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(Foods[0].link))
            startActivity(i)
        }

    }
}