package com.example.displayjoke;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.displayjoke.databinding.ActivityJokeDisplayerBinding;

/**
 * Created by micky on 28-Apr-17.
 */

public class JokeDisplayerActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "jokeKey";

    private String mJoke;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityJokeDisplayerBinding binding = DataBindingUtil.
                setContentView(this, R.layout.activity_joke_displayer);

        mJoke = getIntent().getStringExtra(JOKE_KEY);

        binding.setJoke(mJoke);

    }
}
