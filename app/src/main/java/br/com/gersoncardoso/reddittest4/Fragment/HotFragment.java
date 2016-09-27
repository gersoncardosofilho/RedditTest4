package br.com.gersoncardoso.reddittest4.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.gersoncardoso.reddittest4.Adapter.PostsAdapter;
import br.com.gersoncardoso.reddittest4.Connection.MyAsyncMethods;
import br.com.gersoncardoso.reddittest4.Model.Post;
import br.com.gersoncardoso.reddittest4.R;
import br.com.gersoncardoso.reddittest4.Transaction.PostTransaction;
import br.com.gersoncardoso.reddittest4.Util.ParseJson;


/**
 * Created by gersoncardoso on 22/09/2016.
 */

public class HotFragment extends Fragment  {

    private static final String TAG = "HotFragment";

    String subreddit;
    List<Post> posts;
    private String jsonString;

    private RecyclerView recyclerView;
    private PostsAdapter postsAdapter;

    private MyAsyncMethods listener;

    public HotFragment() {
        posts = new ArrayList<Post>();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hot_fragment, container, false);

        PostTransaction pt = new PostTransaction("", new MyAsyncMethods() {

            @Override
            public void onPostExecute(String result) {

            }
        }, getActivity());
        pt.execute();

        return v;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //initialize();

    }

    private void initialize() {

        Log.d("HotFragment", " foi inicializado");

        PostTransaction pt = new PostTransaction("", new MyAsyncMethods() {

            @Override
            public void onPostExecute(String result) {
                posts = new ArrayList<Post>();
                posts = ParseJson.parsePostsJson(result);
            }
        }, getActivity());
        pt.execute();



    }
}
