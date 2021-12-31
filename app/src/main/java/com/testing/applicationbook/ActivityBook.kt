package com.testing.applicationbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_book.*


class ActivityBook : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        title = "book"

        UnityAdManager.InitializeAd(this)
        UnityAdManager.showBannerAd(bannerLayout, this)

        webViewBook.loadUrl("file:///android_asset/book.html")


    }
}