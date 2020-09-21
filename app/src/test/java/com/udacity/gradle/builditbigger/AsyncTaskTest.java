package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.util.Pair;

import org.junit.Assert;
import org.junit.Test;

//@RunWith(AndroidJUnit4ClassRunner.class)
public class AsyncTaskTest extends EndpointAsyncTask {

    @Test
    public void testVerifyNotEmptyResponse() {
        this.execute(new Pair<Context, String>(null, ""));;
    }

    @Override
    protected void onPostExecute(String result) {
        Assert.assertNotNull("Test failed: Unable to fetch EndpointAsyncTask result!",result);
    }

}