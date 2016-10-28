package br.com.gersoncardoso.reddittest4.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.gersoncardoso.reddittest4.Data.Post;
import br.com.gersoncardoso.reddittest4.R;

/**
 * Created by gerso on 22/09/2016.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    private List<Post> posts;
    public CardView mCardView;
    public TextView post_score, post_details, post_title;

    private PostOnClickListener postOnClickListener;
    private final Context context;

    public PostsAdapter(Context context, List<Post> posts, PostOnClickListener postOnClickListener)
    {
        this.context = context;
        this.posts = posts;
        this.postOnClickListener = postOnClickListener;
    }

    @Override
    public int getItemCount() {
        return this.posts != null ? this.posts.size() : 0;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla o layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_post, parent, false);

        CardView cardView = (CardView) view.findViewById(R.id.q_card_view);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Post post = posts.get(position);
        holder.post_title.setText(post.getTitle());
        holder.post_details.setText(post.getDetails());
        holder.post_score.setText(post.getScore());

        if(postOnClickListener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    postOnClickListener.onClickPost(holder.itemView, position);
                }
            });
        }
    }

    public interface PostOnClickListener{

        public void onClickPost(View view, int position);

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView post_details, post_score, post_title;
        public CardView mCardView;


        public MyViewHolder(View view)
        {
            super(view);
            post_details = (TextView) view.findViewById(R.id.post_details);
            post_score = (TextView) view.findViewById(R.id.post_score);
            post_title = (TextView) view.findViewById(R.id.post_title);
        }
    }

}
