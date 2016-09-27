package br.com.gersoncardoso.reddittest4.MyPreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by gerso on 27/09/2016.
 */

public class MyPreferences {

    public static final String PREFS_NAME = "RedditPreferences";

    public static void saveListField(Context ctx, String fieldName, String list) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS_NAME, ctx.MODE_PRIVATE);
        sp.edit().putString(fieldName, list).apply();
    }
}
