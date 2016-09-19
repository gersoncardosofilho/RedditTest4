package br.com.gersoncardoso.reddittest4.Model;

/**
 * Created by gersoncardoso on 19/09/2016.
 */

public class Post {
    public String subreddit;
    public String title;
    public String author;
    public int points;
    public int numComments;
    public String permalink;
    public String url;
    public String domain;
    public String id;
    public Boolean contest_mode;

    public String getDetails(){
        String details=author
                +" posted this and got "
                +numComments
                +" replies";
        return details;
    }

    public String getTitle(){
        return title;
    }

    public String getScore(){
        return Integer.toString(points);
    }

    public String getPermalink()
    {
        return permalink;
    }


}
