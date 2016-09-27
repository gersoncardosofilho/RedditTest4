package br.com.gersoncardoso.reddittest4.Fragment;

import android.os.AsyncTask;
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

import java.io.IOException;
import java.util.List;

import br.com.gersoncardoso.reddittest4.Adapter.PostsAdapter;
import br.com.gersoncardoso.reddittest4.Model.Post;
import br.com.gersoncardoso.reddittest4.R;
import br.com.gersoncardoso.reddittest4.Util.PostService;

/**
 * Created by gersoncardoso on 27/09/2016.
 */

public class QueziaFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected List<Post> posts;
    private LinearLayoutManager linearLayoutManager;
    private String subreddit;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
        {
            this.subreddit = getArguments().getString("subreddit");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quezia_fragment, container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.q_rv_recycler_view);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        taskPosts();
    }

    private void taskPosts()
    {
        new GetPostsTask().execute();
    }


    private class GetPostsTask extends AsyncTask<Void, Void, List<Post>>
    {
        @Override
        protected List<Post> doInBackground(Void... params) {
            try
            {
                return PostService.getPosts(getContext(), subreddit);
            }catch(IOException ex){
                Log.e("QueziaFragment", ex.getMessage(), ex);
                return null;
            }
        }

        //Atualiza a interface
        protected void onPostExecute(List<Post> posts)
        {
            if(posts != null)
            {
                QueziaFragment.this.posts = posts;
                recyclerView.setAdapter(new PostsAdapter(getContext(), posts, onClickPost()));
            }
        }

        private PostsAdapter.PostOnClickListener onClickPost()
        {
            return new PostsAdapter.PostOnClickListener(){
                @Override
                public void onClickPost(View view, int position) {

                }
            };
        }
    }

}

