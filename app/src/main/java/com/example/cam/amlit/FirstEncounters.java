package com.example.cam.amlit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

public class FirstEncounters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_encounters);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
