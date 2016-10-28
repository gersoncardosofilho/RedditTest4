package br.com.gersoncardoso.reddittest4.Data.Source;

import android.support.annotation.NonNull;

import java.util.List;

import br.com.gersoncardoso.reddittest4.Data.Post;

/**
 * Created by gersoncardoso on 28/10/2016.
 */

public interface PostsDataSource {

    interface LoadPostsCallback
    {
        void onPostsLoaded(List<Post> posts);

        void onDataNotAvailable();
    }

    interface GetPostCallback
    {
        void onPostLoaded(Post post);

        void onDataNotAvailable();
    }

    void getPosts(@NonNull LoadPostsCallback callback);

    //void getPost(@NonNull String id, @NonNull GetPostCallback callback);

    void refreshPosts();
}
