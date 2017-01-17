package br.com.gersoncardoso.reddittest4;

import android.app.Application;

import com.facebook.stetho.Stetho;

import br.com.gersoncardoso.reddittest4.Connection.RestClient;

/**
 * Created by gersoncardoso on 17/01/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        RestClient.initialize();
    }
}
