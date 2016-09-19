package br.com.gersoncardoso.reddittest4;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.gersoncardoso.reddittest4.Fragment.PostsFragment;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int REQUEST_INTERNET = 0;

    private static String PERMISSIONS = Manifest.permission.INTERNET;

    private View mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //addFragment();
        mLayout = findViewById(R.id.fragments_holder);
       addFragment();
    }



    private void addFragment()
    {
        getSupportFragmentManager().beginTransaction().add(R.id.fragments_holder, PostsFragment.newInstance("askreddit")).commit();
    }
}
