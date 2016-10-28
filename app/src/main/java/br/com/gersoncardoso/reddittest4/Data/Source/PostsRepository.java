package br.com.gersoncardoso.reddittest4.Data.Source;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.gersoncardoso.reddittest4.Data.Post;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by gersoncardoso on 28/10/2016.
 */

public class PostsRepository implements PostsDataSource {

    private static PostsRepository INSTANCE = null;
    private final PostsDataSource mPostsDataSource;

    //This variable has package local visibility so it can be accessed from tests
    Map<String, Post> mCachedPosts;

    boolean mChacheIsDirty = false;

    //Prevent direct instantiation
    private PostsRepository(@NonNull PostsDataSource postsDataSource)
    {
        mPostsDataSource = checkNotNull(postsDataSource);
    }

    //Returns the single instance of this class, creating if necessary

    public static PostsRepository getInstance(PostsDataSource postsDataSource)
    {
        if(INSTANCE == null)
        {
            INSTANCE = new PostsRepository(postsDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }

    @Override
    public void getPosts(@NonNull final LoadPostsCallback callback) {
        checkNotNull(callback);

        //Respond immediately with cache if available and not dirty
        if(mCachedPosts != null && !mChacheIsDirty)
        {
            callback.onPostsLoaded(new ArrayList<Post>(mCachedPosts.values()));
            return;
        }

        if(mChacheIsDirty)
        {
            getPosts(callback);
        }
        else
        {
            mPostsDataSource.getPosts(new LoadPostsCallback() {
                @Override
                public void onPostsLoaded(List<Post> posts) {
                    refreshCache(posts);
                    callback.onPostsLoaded(new ArrayList<Post>(mCachedPosts.values()));
                }

                @Override
                public void onDataNotAvailable() {
                    callback.onDataNotAvailable();
                }
            });
        }
    }

    private void refreshCache(List<Post> posts)
    {
        if(mCachedPosts == null)
        {
            mCachedPosts = new LinkedHashMap<>();
        }
        mCachedPosts.clear();;
        for(Post post : posts)
        {
            mCachedPosts.put(post.getId(), post);
        }
        mChacheIsDirty = false;
    }

    @Override
    public void refreshPosts() {
        mChacheIsDirty = true;
    }


}
