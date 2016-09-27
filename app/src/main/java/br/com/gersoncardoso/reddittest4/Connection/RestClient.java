package br.com.gersoncardoso.reddittest4.Connection;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gersoncardoso on 26/09/2016.
 */

public class RestClient
{
    public String url;
    private int responseCode;
    private String message;
    private String response;
    private String subreddit;
    private REQUEST_METHOD request_method;

    public enum REQUEST_METHOD
    {
        GET("GET"),
        POST("POST");

        String value;
        REQUEST_METHOD(String value)
        {
            this.value = value;
        }
    }

   private static String URL_TEMPLATE = "https://www.reddit.com/SUBREDDIT/.json";

    public String getMessage()
    {
        return message;
    }

    public String getResponse()
    {
        return response;
    }

    public RestClient(String subreddit, REQUEST_METHOD request_method)
    {
        this.url = generateURL(subreddit);
        this.request_method = request_method;
    }

    private static String generateURL(String subreddit)
    {
        String url1;
        if(subreddit == "")
        {
            url1 = "https://www.reddit.com/.json";
            return url1;
        }
        else
        {
            url1 = URL_TEMPLATE.replace("{SUBREDDIT}",subreddit);
            return url1;
        }
    }

    public void execute()
    {

        URL url2;
        HttpURLConnection conn;

        try{
            url2 = new URL(url);
            conn = (HttpURLConnection) url2.openConnection();
            conn.setReadTimeout(60000);
            conn.setConnectTimeout(60000);
            conn.setRequestMethod(request_method.toString());
            conn.setUseCaches(false);

            conn.connect();

            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer stringBuffer = new StringBuffer();
            while((line = br.readLine()) != null)
            {
                stringBuffer.append(line);
                stringBuffer.append('\r');
            }
            br.close();
            response = stringBuffer.toString();
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
