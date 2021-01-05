package com.example.wineapplication

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.wineapplication.ui.TypeOfWine.TypeOfWineAdapter
import com.raywenderlich.android.alltherecipes.TypeOfWine
import java.io.*

class MainActivity2 : AppCompatActivity() {
    lateinit var listView: ListView
    val fileName = "MyHistory.txt"
    val filepath = "MyFileDir"
    var fileContent = ""

    fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
                setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        listView = findViewById<ListView>(R.id.recipe_list_view)
        setSupportActionBar(findViewById(R.id.toolbar))
        val bundle: Bundle? = intent.extras
        val Json = bundle?.get("Json")
        val Wines = TypeOfWine.ParseJsonToList(Json as String,this)
        val adapter = TypeOfWineAdapter(this, Wines)
        listView.adapter = adapter
        val HistoryFind = bundle?.get("History")
        var myExternalFile:File = File(getExternalFilesDir(filepath), fileName)
        if(myExternalFile.exists()) {
            if (isExternalStorageReadable()) {
                val contents = myExternalFile.readText()
                print(contents)
                fileContent = contents +"\n"+ HistoryFind.toString()
                myExternalFile.writeBytes(fileContent.toByteArray())
            }
        }
        else
        {
            try {
                myExternalFile.writeBytes(HistoryFind.toString().toByteArray())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            // 1
            val SelectedWine = Wines[position]

            // 2
            val detailIntent = WineDetailActivity.newIntent(context, SelectedWine)

            // 3
            startActivity(detailIntent)
        }

    }

    override fun onStop() {
        Log.v("App","OnSTopcalled")
        super.onStop()
    }
}