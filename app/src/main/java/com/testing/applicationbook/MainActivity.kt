package com.testing.applicationbook

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.unity3d.ads.UnityAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UnityAdManager.InitializeAd(this)

        hideView()

        imageView.setImageResource(R.drawable.icon)
        UnityAdManager.showBannerAd(bannerLayout, this)



        if (isNetworkAvailable()) {
            Handler().postDelayed({


                if (UnityAds.isReady()) {
                    loadingProgressBar.visibility = View.GONE
                    showView()
                } else {
                    Handler().postDelayed({
                        loadingProgressBar.visibility = View.GONE
                        showView()
                    }, 5000)
                }

            }, 5000)

        } else {
            loadingProgressBar.visibility = View.GONE
            showView()

        }



        btnStart.setOnClickListener {
            UnityAdManager.showRewardedVideoAd(this)
            val intent = Intent(this, ActivityPdf::class.java)
            startActivity(intent)
        }

        btnBook.setOnClickListener {
            UnityAdManager.showRewardedVideoAd(this)
            val intent = Intent(this, ActivityBook::class.java)
            startActivity(intent)
        }

        btnWriter.setOnClickListener {
            UnityAdManager.showRewardedVideoAd(this)
            val intent = Intent(this, ActivityWriter::class.java)
            startActivity(intent)
        }

    }

    fun hideView() {
        btnBook.visibility = View.GONE
        btnWriter.visibility = View.GONE
        btnStart.visibility = View.GONE
        bannerLayout.visibility = View.GONE

    }

    fun showView() {
        btnBook.visibility = View.VISIBLE
        btnWriter.visibility = View.VISIBLE
        btnStart.visibility = View.VISIBLE
        bannerLayout.visibility = View.VISIBLE

    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }


}