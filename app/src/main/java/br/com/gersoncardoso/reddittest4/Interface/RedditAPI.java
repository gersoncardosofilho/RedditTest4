package br.com.gersoncardoso.reddittest4.Interface;

import br.com.gersoncardoso.reddittest4.Model.Post;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gersoncardoso on 19/09/2016.
 */

public interface RedditAPI {
    @GET("")
    public void getFeed(@Path("") String posts, Callback<Post> response);
}
