package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.net.sip.SipSession;
import android.os.AsyncTask;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.KeyStore;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase.*;
import android.util.Log;
import android.util.Pair;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;


@RunWith(AndroidJUnit4ClassRunner.class)
public class AsyncTaskTest  extends AndroidTestCase {
    private CountDownLatch signal;
    private String joke;
    private Exception mException;


    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    @Test
    public void testVerifyNotEmptyResponse()  throws Exception{
        signal = new CountDownLatch(1);

        final AsyncTask<Pair<Context, String>, Void, String> myTask = new EndpointAsyncTask(new OnTaskCompleted() {
            @Override
            public void onTaskCompleted(String result, Exception e) {
                joke = result;
                signal.countDown();
                mException = e;
            }
        }).execute();
        try {
            signal.await(21,TimeUnit.SECONDS); // the timeout for the endpoint is 20 so I use 21 seconds timeout for the test
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("AsyncTaskTest","Test failed! Verify that the appengine is running.");
            throw new AssertionError("AssyngTaskTest failed! Errror:\n" +  e.getLocalizedMessage());
        }
        Assert.assertNotNull(joke);
    }
}