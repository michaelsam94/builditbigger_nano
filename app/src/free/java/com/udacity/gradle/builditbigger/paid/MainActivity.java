package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.JokeProvider;
import com.example.displayjoke.JokeDisplayerActivity;
import com.udacity.gradle.builditbigger.*;
import com.udacity.gradle.builditbigger.JokeTask;


public class MainActivity extends AppCompatActivity implements com.udacity.gradle.builditbigger.JokeResponse {

    private Void mJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JokeProvider jokeProvider = new JokeProvider();

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

    public void tellJoke(View view) {
        com.udacity.gradle.builditbigger.JokeTask jokeTask = new JokeTask(this);
        jokeTask.execute();
    }

    public void launchLibraryActivity(String joke) {
        Intent myIntent = new Intent(this, JokeDisplayerActivity.class);
        myIntent.putExtra(JokeDisplayerActivity.JOKE_KEY,joke);
        startActivity(myIntent);
    }


    @Override
    public void getResponse(String response) {
        launchLibraryActivity(response);
    }
}
