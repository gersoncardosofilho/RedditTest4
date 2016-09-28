package br.com.gersoncardoso.reddittest4.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.gersoncardoso.reddittest4.Adapter.PostsAdapter;
import br.com.gersoncardoso.reddittest4.Connection.MyAsyncMethods;
import br.com.gersoncardoso.reddittest4.Model.Post;
import br.com.gersoncardoso.reddittest4.R;
import br.com.gersoncardoso.reddittest4.Transaction.PostTransaction;
import br.com.gersoncardoso.reddittest4.Util.MyUtil;
import br.com.gersoncardoso.reddittest4.Util.ParseJson;


/**
 * Created by gersoncardoso on 22/09/2016.
 */

public class HotFragment extends Fragment  {

    private static final String TAG = "HotFragment";

    protected RecyclerView recyclerView;
    protected List<Post> posts;
    private LinearLayoutManager linearLayoutManager;
    private String subreddit;
    private URL url;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
        {
            this.subreddit = getArguments().getString("section");
            this.url = MyUtil.getReeditUrl(subreddit);
            Log.d(TAG,subreddit);
            Log.d(TAG,url.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_recycler_view);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tasksPost();
    }

    private void taskPosts()
    {
        new GetPostsTask().execute();
    }
}
