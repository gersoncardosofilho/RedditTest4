package br.com.gersoncardoso.reddittest4.Fragment;

import android.content.Context;
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
import br.com.gersoncardoso.reddittest4.Connection.RestClient;
import br.com.gersoncardoso.reddittest4.Model.Post;
import br.com.gersoncardoso.reddittest4.R;
import br.com.gersoncardoso.reddittest4.Transaction.PostTransaction;
import br.com.gersoncardoso.reddittest4.Util.MyUtil;
import br.com.gersoncardoso.reddittest4.Util.ParseJson;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by gersoncardoso on 22/09/2016.
 */

public class HotFragment extends Fragment  {

    private static final String TAG = "HotFragment";

    protected List<Post> posts;
    private LinearLayoutManager linearLayoutManager;
    private String subreddit;
    private URL url;

    @BindView(R.id.rv_recycler_view)
    RecyclerView recyclerView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        RestClient.getInstance().getHotPosts(postsCallback);
    }

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

    private Callback<Post> postsCallback = new Callback<Post>() {
        @Override
        public void onResponse(Call<Post> call, Response<Post> response) {
            Log.d(TAG, "postsCallback response.");
        }

        @Override
        public void onFailure(Call<Post> call, Throwable t) {
            Log.d(TAG, "postsCallback failure.");
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_fragment, container, false);
        ButterKnife.bind(this, view);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return view;
    }


}
