package com.udacity.gradle.builditbigger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends MainActivityCommon {
    FreeMainActivityFragment mMainActivityFragment;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        // try to find an existing instance
        Fragment frag = fragmentManager.findFragmentByTag(FreeMainActivityFragment.TAG);
        if (frag == null) {
            mMainActivityFragment = new FreeMainActivityFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment, mMainActivityFragment, FreeMainActivityFragment.TAG)
                    .commit();
        }

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mMainActivityFragment.showProgressBar(true);
                MainActivity.super.tellJoke(null);

                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

    }

    public void tellJoke(android.view.View view) {
        mMainActivityFragment.showProgressBar(true);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            super.tellJoke(view);
        }
    }

    @Override
    public void onTaskCompleted(String result, Exception e) {
        mMainActivityFragment.showProgressBar(false);
        super.onTaskCompleted(result,e );
    }

}
