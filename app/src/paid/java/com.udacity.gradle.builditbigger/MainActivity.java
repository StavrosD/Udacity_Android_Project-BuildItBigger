package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import gr.sdim.jokes_android_library.DisplayJokeActivity;


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

    public void tellJoke(View view) {
        mMainActivityFragment.showProgressBar(true);
        super.tellJoke(null);
    }


    public void handleDataQueryTaskResponse(String result) {
        mMainActivityFragment.showProgressBar(false);
        super.handleDataQueryTaskResponse(result);
    }
}
