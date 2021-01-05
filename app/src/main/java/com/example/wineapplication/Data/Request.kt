package com.example.wineapplication.Data

import android.util.Log
import org.json.JSONObject
import java.net.URL
import kotlin.reflect.typeOf

class Request(private val url: String) {



    fun run(): String {
        val URL = URL(url)
        try {
            val GetBackJson = URL(url).readText()
            print(GetBackJson)
            if(GetBackJson.contains("failure"))
            {
                return "Chyba"
            }
            Log.v("Json",GetBackJson)
            return GetBackJson
        }
        catch (ex: Exception)
        {
            return "Chyba"
        }



    }
}