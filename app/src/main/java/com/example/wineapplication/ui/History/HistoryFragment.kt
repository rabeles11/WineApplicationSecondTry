package com.example.wineapplication.ui.History

import android.os.Bundle
import android.os.Environment
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.wineapplication.R
import java.io.File


class HistoryFragment : Fragment(R.layout.fragment_history) {
    fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
                setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val fileName = "MyHistory.txt"
        val filepath = "MyFileDir"
        val view: View = inflater.inflate(R.layout.fragment_history, container, false)
        val textViewHistory = view.findViewById<TextView>(R.id.textView6)
        var myExternalFile: File = File(activity?.getExternalFilesDir(filepath), fileName)
        if (myExternalFile.exists()) {
            if (isExternalStorageReadable()) {
                val contents = myExternalFile.readText()
                print(contents)
                textViewHistory.setText(contents)
            }
        }


        return view
    }
}