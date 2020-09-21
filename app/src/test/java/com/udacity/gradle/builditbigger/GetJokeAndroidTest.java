
package com.udacity.gradle.builditbigger;


//import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import gr.sdim.libjavajokes.JavaJokesClass;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

//@RunWith(AndroidJUnit4ClassRunner.class)
public class GetJokeAndroidTest {

  @Test
    public void testVerifyNotEmptyResponse() {
       String joke =  new JavaJokesClass().getRandomJoke();
        Assert.assertNotNull("Test failed: Library did not return a value (null received)",joke);
    }
    @Test
    public void testVerifyNotDefaultResponse(){
        String joke =  new JavaJokesClass().getRandomJoke();

        assertNotSame("Error: Class not initialized correctly, the default message returned" ,"3",joke);
    }
}
