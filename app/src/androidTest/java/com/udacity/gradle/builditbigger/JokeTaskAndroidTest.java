package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by micky on 29-Apr-17.
 */

@RunWith(AndroidJUnit4.class)
public class JokeTaskAndroidTest extends AndroidTestCase implements JokeResponse {

    @Test
    public void testJokeTask(){
        JokeTask asyncTask = new JokeTask(getContext());
        asyncTask.delegate = this;
        asyncTask.execute();
    }

    @Override
    public void getResponse(String response) {
        assertEquals("This is totally a funny joke",response);
    }
}
