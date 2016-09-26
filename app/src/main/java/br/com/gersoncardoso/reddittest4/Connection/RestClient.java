package br.com.gersoncardoso.reddittest4.Connection;

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

    public RestClient(String subreddit)
    {
        this.subreddit = subreddit;
    }

    private static String URL_TEMPLATE = "https://www.reddit.com/SUBREDDIT/.json";

    public int getResponseCode()
    {
        return responseCode;
    }

    public String getMessage()
    {
        return message;
    }

    public String getResponse()
    {
        return response;
    }

    private void generateURL(String subreddit)
    {
        if(subreddit == "")
        {
            url = "https://www.reddit.com/.json";
        }
        else
        {
            url = url.replace("{SUBREDDIT}",subreddit);
        }
    }

    public void execute()
    {
        generateURL(subreddit);

        URL url2;
        HttpURLConnection conn;

        try{
            url2 = new URL(url);
            conn = (HttpURLConnection) url2.openConnection();
            conn.setReadTimeout(60000);
            conn.setConnectTimeout(60000);
            conn.setRequestMethod("GET");
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
