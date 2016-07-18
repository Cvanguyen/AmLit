package com.example.cam.amlit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;

public class NativeAmericans extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_americans);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] nativeMenu = {"Overview","Codex","Community" };
        //final int[] nativeImage = {};
        final TabHost host = (TabHost)findViewById(R.id.tabHost);

        host.setup();

        //Tab Name
        TabHost.TabSpec spec = host.newTabSpec("History");
        spec.setIndicator("History");
        spec.setContent(R.id.nativeHistoricalList);
        host.addTab(spec);

        //Tab Win
        spec = host.newTabSpec("Text");
        spec.setIndicator("Text");
        spec.setContent(R.id.nativeContextualList);
        host.addTab(spec);
    }
    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }

}
