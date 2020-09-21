package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.udacity.gradle.builditbigger.databinding.FragmentMainBinding;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public static final String TAG = "JOKES_FRAGMENT";

    private  FragmentMainBinding mFragmentMainBinding;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentMainBinding = FragmentMainBinding.inflate(inflater,container,false);
        View view = mFragmentMainBinding.getRoot();
        return view;
    }

    public void showProgressBar(boolean show){
        if (show == true) {
            mFragmentMainBinding.button.setEnabled(false);  // prevent multiple requests if the user try to click the button again before getting the results from the first click
            mFragmentMainBinding.progressBar.setVisibility(View.VISIBLE);
        } else {
            mFragmentMainBinding.progressBar.setVisibility(View.GONE);
            mFragmentMainBinding.button.setEnabled(true);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFragmentMainBinding = null;
    }
}
