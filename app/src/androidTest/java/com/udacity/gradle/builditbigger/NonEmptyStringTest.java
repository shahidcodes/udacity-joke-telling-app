package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class NonEmptyStringTest {

    @Test
    public void AsyncTask_RetrievesNonEmptyString(){
        String result= null;
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        JokerAsyncTask jokerAsyncTask = new JokerAsyncTask(context,null);
        jokerAsyncTask.execute();
        try {
            result = jokerAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assert result != null;
    }
}
