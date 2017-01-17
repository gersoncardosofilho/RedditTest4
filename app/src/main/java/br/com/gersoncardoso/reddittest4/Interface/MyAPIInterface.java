package br.com.gersoncardoso.reddittest4.Interface;

import br.com.gersoncardoso.reddittest4.Model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gersoncardoso on 17/01/2017.
 */

public interface MyAPIInterface {

    //GetPosts
    @GET(".json")
    Call<Post> getHotPosts();



}




