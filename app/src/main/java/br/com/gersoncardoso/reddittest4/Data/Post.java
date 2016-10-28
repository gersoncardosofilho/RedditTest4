package br.com.gersoncardoso.reddittest4.Data;

import android.os.Parcel;
import android.os.Parcelable;

//Created by Gerson Cardoso Filho - 28/outubro/2016

public class Post implements Parcelable
{
    //Describe all entities
    public String subreddit;
    public String title;
    public String author;
    public int points;
    public int numComments;
    public String permalink;
    public String url;
    public String domain;
    public String id;

    public String getDetails(){
        String details=author
                +" posted this and got "
                +numComments
                +" replies";
        return details;
    }
    //End entities


    //Getters and Setters


    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Constructor
    public Post(String subreddit, String title, String author, int points, int numComments, String permalink, String url, String domain, String id, Boolean contest_mode)
    {
        this.subreddit = subreddit;
        this.title = title;
        this.author = author;
        this.points = points;
        this.numComments = numComments;
        this.permalink = permalink;
        this.url = url;
        this.domain = domain;
        this.id = id;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(subreddit);
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeInt(points);
        parcel.writeInt(numComments);
        parcel.writeString(permalink);
        parcel.writeString(url);
        parcel.writeString(domain);
        parcel.writeString(id);
    }

    //Constructor for createFromParcel
    public Post(Parcel in)
    {
        this.subreddit = in.readString();
        this.title = in.readString();
        this.author = in.readString();
        this.points = in.readInt();
        this.numComments = in.readInt();
        this.permalink = in.readString();
        this.url = in.readString();
        this.domain = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }
}
