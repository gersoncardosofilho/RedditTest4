package br.com.gersoncardoso.reddittest4.Connection;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.gersoncardoso.reddittest4.Util.MyCache;

/**
 * Created by gersoncardoso on 19/09/2016.
 */

public class Connection {

    public static HttpURLConnection getConnection(String url)
    {
        URL u = null;
        try{
           u = new URL(url);
        }catch(MalformedURLException ex){
            Log.e("Invalid URL ", url);
            return null;
        }
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
        byte[] t = MyCache.read(url);
        String cached = null;
        if(t != null)
        {
            Log.d("MSG", "Using cache for: " + url);
            return cached;
        }

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
            MyCache.write(url,sb.toString());
            return sb.toString();
        }catch(IOException ex){
            Log.d("READ FAILED", ex.toString());
            return null;
        }
    }

    //Post data to the url
    public static boolean writeToConnection(HttpURLConnection conn, String data){
        try{
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
            pw.write(data);
            pw.close();
            return true;
        }catch(IOException ex){
            Log.e("Write Post Error ", ex.toString());
            return false;
        }
    }
}
