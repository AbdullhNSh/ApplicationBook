package com.testing.applicationbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_writer.*

class ActivityWriter : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writer)

        title = "Writer"

        UnityAdManager.InitializeAd(this)
        UnityAdManager.showBannerAd(bannerLayout, this)

        webViewWriter.loadUrl("file:///android_asset/writer.html")


    }
}