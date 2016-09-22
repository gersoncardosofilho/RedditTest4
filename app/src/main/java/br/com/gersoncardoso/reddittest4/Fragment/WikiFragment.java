package br.com.gersoncardoso.reddittest4.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.gersoncardoso.reddittest4.R;

/**
 * Created by gersoncardoso on 22/09/2016.
 */

public class WikiFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wiki_fragment,container,false);
        return view;
    }
}
