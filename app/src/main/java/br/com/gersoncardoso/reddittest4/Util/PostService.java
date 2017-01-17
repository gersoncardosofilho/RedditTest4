package br.com.gersoncardoso.reddittest4.Util;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.List;

import br.com.gersoncardoso.reddittest4.Connection.RestClient__;
import br.com.gersoncardoso.reddittest4.Model.Post;

/**
 * Created by gersoncardoso on 27/09/2016.
 */

public class PostService {

    private static final String URL = "https://www.reddit.com/{SUBREDDIT}/.Json";
    private static final boolean LOG_ON = false;
    private static final String TAG = "PostService";
    private static String url;

    public static List<Post> getPosts(Context context, String subreddit) throws IOException
    {
       url = "https://www.reddit.com/.json";

        List<Post> posts = getPostsFromUrl(context, url);
        return posts;
    }

    public static List<Post> getPostsFromUrl(Context context, String url) throws IOException
    {
        RestClient__ restClient = new RestClient__(url, RestClient__.REQUEST_METHOD.GET);
        restClient.execute();
        String json = restClient.getResponse();
        salvarCache(context,url,json);
        List<Post> posts = ParseJson.parsePostsJson(json);
        return posts;
    }

    private static void salvarCache(Context context, String url, String json) {
        String fileName = url.substring(url.lastIndexOf("/")+1);
        // Cria o arquivo, exemplo:
        // /data/data/br.com.livroandroid.carros/files/carros_luxo.json
        File file = FileUtils.getFile(context, fileName);
        // Escreve a string no arquivo
        IOUtils.writeString(file, json);
        Log.d(TAG, "Arquivo salvo: " + file);
    }
}
