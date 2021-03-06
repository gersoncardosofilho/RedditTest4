package br.com.gersoncardoso.reddittest4.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.gersoncardoso.reddittest4.Model.Post;
import br.com.gersoncardoso.reddittest4.R;


/**
 * Created by gersoncardoso on 22/09/2016.
 */

public class NewFragment extends Fragment {

    Handler handler;

    String subreddit;
    List<Post> posts;


    ArrayList<Post> testePost = new ArrayList<Post>();


    public NewFragment()
    {
        handler=new Handler();
        posts=new ArrayList<Post>();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Acesso", "1");
        setRetainInstance(true);
        //initialize();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Acesso", "2");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_fragment, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);

        return view;
    }

    private void initialize(){
        // This should run only once for the fragment as the
        // setRetainInstance(true) method has been called on
        // this fragment



        /*Post post = new Post();
        post.author = "Gerson C";
        post.points = 100;
        post.numComments = 1000;
        post.title = "Post 1 Titulo";
        posts.add(post);

        Post post2 = new Post();
        post2.author = "Eliane G";
        post2.points = 200;
        post2.numComments = 2000;
        post2.title = "Post 2 Titulo";
        posts.add(post2);*/

        Log.d("Posts", posts.toString());


    }

}
