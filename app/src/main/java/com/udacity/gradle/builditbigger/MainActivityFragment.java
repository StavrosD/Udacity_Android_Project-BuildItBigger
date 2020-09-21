package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.udacity.gradle.builditbigger.BuildConfig.IS_PAID;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public static final String TAG = "JOKES_FRAGMENT";
    private ProgressBar mProgressBar;
    private Button mButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mProgressBar = root.findViewById(R.id.progressBar);
        mButton = root.findViewById(R.id.button);
        return root;
    }

    public void showProgressBar(boolean show){
        if (show == true) {
            mButton.setEnabled(false);  // prevent multiple requests if the user try to click the button again before getting the results from the first click
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mButton.setEnabled(true);
        }

    }

}
