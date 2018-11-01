package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

import ml.shahidkamal.libjokerui.JokerActivity;

public class JokerAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService  = null;
    private final Context context;
    private ProgressDialog pd;


    public JokerAsyncTask(Context context, ProgressDialog pd) {
        this.context = context;
        this.pd = pd;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if (myApiService == null){
            MyApi.Builder builder = new MyApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),
                    null
            ).setRootUrl("https://joker.localtunnel.me/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        if(pd!=null) pd.dismiss();
        Intent intent = new Intent(context, JokerActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, s);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
