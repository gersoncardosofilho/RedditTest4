package br.com.gersoncardoso.reddittest4.Util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.gersoncardoso.reddittest4.Model.Post;

/**
 * Created by gerso on 26/09/2016.
 */

public class ParseJson {

    private static String after;

    public static List<Post> parsePostsJson(String strJson )
    {
        List<Post> postsList = new ArrayList<Post>();

        try{
            JSONObject data = new JSONObject(strJson). getJSONObject("data");
            JSONArray children = data.getJSONArray("children");
            after = data.getString("after");
            for(int i=0; i<children.length();i++)
            {
                JSONObject cur = children.getJSONObject(i).getJSONObject("data");
                Post p = new Post();
                p.title = cur.optString("title");
                p.url = cur.optString("url");
                p.numComments = cur.optInt("num_comments");
                p.points = cur.optInt("score");
                p.author=cur.optString("author");
                p.subreddit=cur.optString("subreddit");
                p.permalink=cur.optString("permalink");
                p.domain=cur.optString("domain");
                p.id=cur.optString("id");
                if(p.title!=null)
                    postsList.add(p);
            }
        }catch(Exception ex){
            Log.e("fetchPosts()", ex.toString());
        }
        return postsList;
    }


}
