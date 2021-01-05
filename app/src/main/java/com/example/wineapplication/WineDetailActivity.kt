package com.example.wineapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.raywenderlich.android.alltherecipes.TypeOfWine

class WineDetailActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_URL = "url"

        fun newIntent(context: Context, wine: TypeOfWine): Intent {
            val detailIntent = Intent(context, WineDetailActivity::class.java)

            detailIntent.putExtra(EXTRA_TITLE, wine.title)
            detailIntent.putExtra(EXTRA_URL, wine.link)

            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wine_detail)

        // 1
        val title = intent.extras?.getString(EXTRA_TITLE)
        val url = intent.extras?.getString(EXTRA_URL)

        // 2
        setTitle(title)

        // 3
        webView = findViewById(R.id.detail_web_view)

            // 4
        webView.loadUrl(url)
    }
}