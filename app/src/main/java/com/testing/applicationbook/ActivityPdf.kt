package com.testing.applicationbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pdf.*

class ActivityPdf : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)

        title = "PDF"

        UnityAdManager.InitializeAd(this)
        UnityAdManager.showBannerAd(bannerLayout, this)

        pdfView.fromAsset("start.pdf").load()


    }


}



