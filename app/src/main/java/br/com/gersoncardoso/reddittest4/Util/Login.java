package br.com.gersoncardoso.reddittest4.Util;

import android.util.Log;

import java.net.HttpURLConnection;

import br.com.gersoncardoso.reddittest4.Connection.Connection;

import static br.com.gersoncardoso.reddittest4.Connection.Connection.getConnection;

/**
 * Created by gersoncardoso on 20/09/2016.
 */

public class Login {
    private final String REDDIT_LOGIN_URL = "https://ssl.reddit.com/api/login";

    //Reddit cookie string
    //This should be used by other methods after a successful login
    private String redditCokie = "";

    //This methos lets you login to reddit
    //It fetches the cookie which can be used in subsequent calls to the reddit API
    private boolean login(String username, String password)
    {
        HttpURLConnection connection = getConnection(REDDIT_LOGIN_URL);

        if(connection == null)
        {
            return false;
        }

        //Parameters API needs
        String data = "user="+username+"&passwd="+password;
        if(!Connection.writeToConnection(connection,data))
        {
            return false;
        }else{
            String cookie = connection.getHeaderField("set-cookie");

            if(cookie == null)
            {
                return false;
            }
            else{
                cookie = cookie.split(";")[0];
                if(cookie.startsWith("reddit_first"))
                {
                    Log.e("Error: ","Unable to login.");
                    return false;
                }
                else if(cookie.startsWith("reddit_session")){
                    //Login success
                    Log.d("Success", cookie);
                    redditCokie = cookie;
                    return true;
                }
                return false;
            }
        }



    }
}
