package br.com.gersoncardoso.reddittest4.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.gersoncardoso.reddittest4.Model.Post;
import br.com.gersoncardoso.reddittest4.R;
import br.com.gersoncardoso.reddittest4.Transaction.PostTransaction;
import br.com.gersoncardoso.reddittest4.Util.PostsHolder;

/**
 * Created by gersoncardoso on 22/09/2016.
 */

public class HotFragment extends Fragment {

    ListView postsList;
    ArrayAdapter<Post> adapter;
    Handler handler;
    TextView testeView;
    Button button;

    String subreddit;
    List<Post> posts;
    PostsHolder postsHolder;

    public HotFragment(){
        handler=new Handler();
        posts=new ArrayList<Post>();
    }

    public static Fragment newInstance(String subreddit){
        HotFragment hf=new HotFragment();
        hf.subreddit=subreddit;
        hf.postsHolder=new PostsHolder(hf.subreddit);
        return hf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.hot_fragment, container, false);
        postsList=(ListView)v.findViewById(R.id.posts_list);
        testeView=(TextView)v.findViewById(R.id.testeView);
        button = (Button) v.findViewById(R.id.button);
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
        initialize();
    }

    private void initialize(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostTransaction pt = new PostTransaction(""){
                    @Override
                    protected void onPostExecute(String s) {
                        testeView.setText(s);
                    }
                };

                pt.execute();
            }
        });
    }

}
