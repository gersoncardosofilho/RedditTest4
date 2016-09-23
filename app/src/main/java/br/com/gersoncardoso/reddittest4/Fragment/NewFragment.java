package br.com.gersoncardoso.reddittest4.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.gersoncardoso.reddittest4.Adapter.PostsAdapter;
import br.com.gersoncardoso.reddittest4.R;

/**
 * Created by gersoncardoso on 22/09/2016.
 */

public class NewFragment extends Fragment {

    public NewFragment()
    {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_fragment, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);

        PostsAdapter postsAdapter = new PostsAdapter(new String[] {"teste um", "teste dois", "teste tres"});
        rv.setAdapter(postsAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);

        return view;
    }
}
