package br.com.gersoncardoso.reddittest4.Util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gersoncardoso on 19/09/2016.
 */

public class RemoteData {

    public static HttpURLConnection getConnection(String url)
    {
        System.out.println("URL: " + url);
        HttpURLConnection conn = null;

        try{
            conn = (HttpURLConnection)new URL(url).openConnection();
            conn.setReadTimeout(30000);
            conn.setRequestProperty("User-Agent","Alien V1.0");
        }catch(MalformedURLException ex){
            Log.e("getConnection()","Invalid URL: " + ex.toString());
        }catch(IOException ex){
            Log.e("getConnection()","Could not connect " + ex.toString());
        }
        return conn;
    }

    public static String readContents(String url)
    {
        HttpURLConnection conn = getConnection(url);
        if(conn==null)
        {
            return null;
        }

        try{
            StringBuffer sb = new StringBuffer(8192);
            String temp = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while((temp=br.readLine())!=null)
                sb.append(temp).append("\n");
            br.close();
            return sb.toString();
        }catch(IOException ex){
            Log.d("READ FAILED", ex.toString());
            return null;
        }
    }
}
