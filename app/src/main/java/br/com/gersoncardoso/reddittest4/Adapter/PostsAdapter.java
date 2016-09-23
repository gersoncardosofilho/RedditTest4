package br.com.gersoncardoso.reddittest4.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.gersoncardoso.reddittest4.Model.Post;
import br.com.gersoncardoso.reddittest4.R;

/**
 * Created by gerso on 22/09/2016.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    private List<Post> postsList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView post_score, post_details, post_title;
        public MyViewHolder(View view)
        {
            super(view);
            mCardView = (CardView) view.findViewById(R.id.card_view);
            post_details = (TextView) view.findViewById(R.id.post_details);
            post_score = (TextView) view.findViewById(R.id.post_score);
            post_title = (TextView) view.findViewById(R.id.post_title);
        }
    }



    public PostsAdapter(List<Post> postsList)
    {
        this.postsList = postsList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        //set views size, margins, paddings and layout params

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Post post = postsList.get(position);
        holder.post_title.setText(post.getTitle());
        holder.post_details.setText(post.getDetails());
        holder.post_score.setText(post.getScore());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}
