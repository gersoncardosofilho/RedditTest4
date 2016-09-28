package br.com.gersoncardoso.reddittest4.Util;

import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gerso on 27/09/2016.
 */

public class MyUtil {

    private static final String TAG = "MyUtil";
    private static final String URL_TEMPLATE = "https://www.reddit.com/{SUBREDDIT}/.json";
    private static String url = "";

    /**
     *
     * @param subreddit Type of subreddit that will populate the posts
     * @return the reddit url according passed subreddit
     */
    public static URL getReeditUrl(String subreddit) {
        if(subreddit != null)
            if(subreddit == "")
            {
                try{
                    url = URL_TEMPLATE.replace("{SUBREDDIT}/","");
                    URL urlFinal = new URL(url);
                    return urlFinal;
                }catch(MalformedURLException ex)
                {
                    Log.e(TAG, ex.getMessage());
                    return null;
                }
            }
        else if(subreddit == "new")
            {
                try{
                    url = URL_TEMPLATE.replace("{SUBREDDIT}",subreddit);
                    URL urlFinal = new URL(url);
                    return urlFinal;
                }catch(MalformedURLException ex)
                {
                    Log.e(TAG, ex.getMessage());
                    return null;
                }
            }
        return null;
    }
}
