package br.com.gersoncardoso.reddittest4.Transaction;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import br.com.gersoncardoso.reddittest4.Connection.MyAsyncMethods;
import br.com.gersoncardoso.reddittest4.Connection.RestClient;
import br.com.gersoncardoso.reddittest4.Model.Post;

/**
 * Created by gersoncardoso on 26/09/2016.
 */

public class PostTransaction extends AsyncTask<String, String, String> {

    private MyAsyncMethods myAsyncMethods;
    private Context context;
    RestClient restClient;
    private String response;

    List<Post> posts;
    String subreddit;

    public PostTransaction(String subreddit, MyAsyncMethods myAsyncMethods, Activity activity)
    {
        Log.d("PostTransaction","1 - constructor");

        this.myAsyncMethods = myAsyncMethods;
        this.subreddit = subreddit;
        this.context = activity;
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d("PostTransaction","2 - doInBackground");
        restClient = new RestClient(subreddit, RestClient.REQUEST_METHOD.GET);
        restClient.execute();
        return restClient.getResponse();
    }

    @Override
    protected void onPostExecute(String result) {

        Log.d("PostTransaction","3 - onPostExecute");
        if(result != null) {
            Log.d("String json: ", result);
            myAsyncMethods.onPostExecute(result);
        }
        else
        {
            myAsyncMethods.onPostExecute("");
        }

    }
}
