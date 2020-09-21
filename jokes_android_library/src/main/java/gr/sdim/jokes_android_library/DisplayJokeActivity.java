package gr.sdim.jokes_android_library;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import gr.sdim.jokes_android_library.databinding.ActivityDisplayJokeBinding;

public class DisplayJokeActivity extends AppCompatActivity {
    public static String JOKE_ACTIVITY_KEY = "Joke activity key";
   private TextView mJokeTextView;
   private  String mJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mJoke = getIntent().getStringExtra(JOKE_ACTIVITY_KEY);
        ActivityDisplayJokeBinding binding = ActivityDisplayJokeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mJokeTextView = binding.jokeTextView;
        if (mJoke != null && !mJoke.isEmpty()) {
            mJokeTextView.setText(mJoke);
        } else {
            mJokeTextView.setText("No joke received so I will tell you one! \n On a phone call: \n Technician: Click on \"My Computer\"\nClient: How can I click your computer from my computer?");
        }





    }

    //Toast.makeText(this, , Toast.LENGTH_SHORT).show();
}