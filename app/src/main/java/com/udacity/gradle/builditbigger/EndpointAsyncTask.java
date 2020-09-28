package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class EndpointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;

    private OnTaskCompleted listener;
    private Exception mException;
    public EndpointAsyncTask(OnTaskCompleted listener){
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
            if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();

        }


        try {
            return myApiService.tellMeAJoke().execute().getJoke();
        } catch (IOException e) {
            e.printStackTrace();
            mException = e;
            return null;
        }
    }

    @Override
    protected void onCancelled() {
        if (listener != null){
            mException = new InterruptedException("AsyncTask cancelled");
            this.listener.onTaskCompleted(  null, mException);
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (listener != null) {
            listener.onTaskCompleted(result,mException);
        }

    }


}