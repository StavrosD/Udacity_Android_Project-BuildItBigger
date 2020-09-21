package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class MainActivity extends MainActivityCommon {
    MainActivityFragment mMainActivityFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        // try to find an existing instance
        Fragment frag = fragmentManager.findFragmentByTag(MainActivityFragment.TAG);
        if (frag == null) {
            mMainActivityFragment = new MainActivityFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment, mMainActivityFragment, MainActivityFragment.TAG)
                    .commit();
        }
    }

    public void tellJoke(android.view.View view) {
        mMainActivityFragment.showProgressBar(true);
        super.tellJoke(view);
    }

    public void handleDataQueryTaskResponse(String result) {
        mMainActivityFragment.showProgressBar(false);
        super.handleDataQueryTaskResponse(result);
    }
}
