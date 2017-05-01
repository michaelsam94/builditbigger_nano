package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.os.AsyncTask;


import com.example.micky.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.*;


import java.io.IOException;

/**
 * Created by micky on 28-Apr-17.
 */

public class JokeTask extends AsyncTask<Void,Void,String> {
    private static MyApi myApiService = null;
    public com.udacity.gradle.builditbigger.JokeResponse delegate = null;

    public JokeTask(Context context){
        if(context instanceof com.udacity.gradle.builditbigger.JokeResponse) {
            delegate = (com.udacity.gradle.builditbigger.JokeResponse) context;
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null);
            builder.setRootUrl("http://192.168.1.5:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                    abstractGoogleClientRequest.setDisableGZipContent(true);
                }
            });
            myApiService = builder.build();
        }
        String response = null;
        try {
            response = myApiService.getJoke().execute().getData();
            return response;
        } catch (IOException e){
            return e.getMessage();
        } finally {
            return response;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        delegate.getResponse(s);
    }
}
