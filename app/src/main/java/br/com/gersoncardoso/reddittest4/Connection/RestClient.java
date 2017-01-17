package br.com.gersoncardoso.reddittest4.Connection;

import java.util.concurrent.TimeUnit;

import br.com.gersoncardoso.reddittest4.Interface.MyAPIInterface;
import br.com.gersoncardoso.reddittest4.Model.Post;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gersoncardoso on 17/01/2017.
 */

public class RestClient {
    private static final String TAg = "RestClient";
    private static final String BASE_URL = "https://reddit.com/";
    private static final long TIMEOUT=60000;

    private static RestClient instance;
    private Retrofit retrofit;
    MyAPIInterface apiService;

    public static void initialize(){
        if (instance == null)
            instance = new RestClient();
    }

    //Singleton Instance Getter
    public static RestClient getInstance(){
        initialize();;

        return instance;
    }

    //Constructor
    private RestClient(){
        final OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.apiService = retrofit.create(MyAPIInterface.class);
    }

    public void getHotPosts(Callback<Post> callback){
        Call<Post>call = apiService.getHotPosts();
        call.enqueue(callback);
    }

}
