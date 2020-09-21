package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.udacity.gradle.builditbigger.databinding.ActivityMainBinding;

import gr.sdim.jokes_android_library.DisplayJokeActivity;


public class MainActivityCommon extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(android.view.View view) {
        //JavaJokesClass jjc = new JavaJokesClass();
        //String newJoke = jjc.getRandomJoke();
        //launchJokeActivity(this,newJoke);
        new EndpointAsyncTask().execute(new Pair<Context, String>(this, ""));;

    }

    public void launchJokeActivity(MainActivityCommon view, String joke) {

        Intent intent = new Intent(this, DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_ACTIVITY_KEY, joke);
        startActivity(intent);
    }

    public void handleDataQueryTaskResponse(String result) {

        launchJokeActivity(this,result);
    }
}
