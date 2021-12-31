package com.testing.applicationbook

import com.unity3d.ads.UnityAds
import com.unity3d.ads.IUnityAdsListener
import android.widget.LinearLayout
import android.app.Activity
import android.content.Context
import android.util.Log
import com.unity3d.services.banners.BannerView
import com.unity3d.services.banners.UnityBannerSize
import com.unity3d.ads.UnityAds.FinishState
import com.unity3d.ads.UnityAds.UnityAdsError
import com.unity3d.services.banners.BannerView.IListener
import com.unity3d.services.banners.BannerErrorInfo

object UnityAdManager {
    private const val GAME_ID = "4528027"
    private const val REWARD_ID = "Rewarded_Android"
    private const val INTER_ID = "Interstitial_Android"
    private const val BANNER_ID = "Banner_Android"
    private const val testMode = true

    /**
     * private static final String GAME_ID   = "your game id";
     * private static final String REWARD_ID = "your reward id";
     * private static final String INTER_ID  = "your inter id";
     * private static final String BANNER_ID = "your banner id";
     * private static final boolean testMode = false; */
    fun InitializeAd(context: Context?) {
        val myAdsListener = UnityAdsListener()
        UnityAds.addListener(myAdsListener)
        UnityAds.initialize(context, GAME_ID, testMode)
    }

    //use this for Reward Ad
    fun InitializeAd(context: Context?, unityAdsListener: IUnityAdsListener?) {
        UnityAds.addListener(unityAdsListener)
        UnityAds.initialize(context, GAME_ID, testMode)
    }

    //change layout with your layout, LinearLayout just example
    fun showBannerAd(bannerLayout: LinearLayout, activity: Activity?) {
        val bannerListener = UnityBannerListener()
        val bannerView = BannerView(activity, BANNER_ID, UnityBannerSize(320, 50))
        bannerView.listener = bannerListener
        bannerView.load()
        bannerLayout.addView(bannerView)
    }

    fun showInterstitialAd(activity: Activity?) {
        if (UnityAds.isReady(INTER_ID)) {
            UnityAds.show(activity, INTER_ID)
        }
    }

    fun showRewardedVideoAd(activity: Activity?) {
        if (UnityAds.isReady(REWARD_ID)) {
            UnityAds.show(activity, REWARD_ID)
        }
    }

    fun DestroyAd(bannerView: BannerView) {
        bannerView.destroy()
    }

     class UnityAdsListener() : IUnityAdsListener {
        override fun onUnityAdsReady(adUnitId: String) {

            // Implement functionality for an ad being ready to show.
        }

        override fun onUnityAdsStart(adUnitId: String) {
            // Implement functionality for a user starting to watch an ad.
        }

        override fun onUnityAdsFinish(adUnitId: String, finishState: FinishState) {
            // Implement functionality for a user finishing an ad.
        }

        override fun onUnityAdsError(error: UnityAdsError, message: String) {
            // Implement functionality for a Unity Ads service error occurring.
        }
    }

    // Implement listener methods:
    private class UnityBannerListener : IListener {
        override fun onBannerLoaded(bannerAdView: BannerView) {
            // Called when the banner is loaded.
        }

        override fun onBannerFailedToLoad(bannerAdView: BannerView, errorInfo: BannerErrorInfo) {
            Log.d("SupportTest", "Banner Error")
            // Note that the BannerErrorInfo object can indicate a no fill (see API documentation).
        }

        override fun onBannerClick(bannerAdView: BannerView) {
            // Called when a banner is clicked.
        }

        override fun onBannerLeftApplication(bannerAdView: BannerView) {
            // Called when the banner links out of the application.
        }
    }


}