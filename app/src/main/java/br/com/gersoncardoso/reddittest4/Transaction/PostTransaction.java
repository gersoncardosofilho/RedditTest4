package br.com.gersoncardoso.reddittest4.Transaction;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import br.com.gersoncardoso.reddittest4.Connection.MyAsyncMethods;
import br.com.gersoncardoso.reddittest4.Connection.RestClient;

/**
 * Created by gersoncardoso on 26/09/2016.
 */

public class PostTransaction extends AsyncTask<String, String, String> {

    private MyAsyncMethods myAsyncMethods;
    private Context context;
    RestClient restClient;
    private String response;

    public PostTransaction(String subreddit)
    {
        try{
            restClient = new RestClient(subreddit);
            restClient.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    @Override
    protected String doInBackground(String... strings) {
        restClient.execute();
        response = restClient.getResponse();
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("String json: ",s);
    }
}
