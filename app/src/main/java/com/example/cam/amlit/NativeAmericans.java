package com.example.cam.amlit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class NativeAmericans extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_americans);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] nativeStory = {"Codices","Newspaper Rock","Hopi Myths"};
        final String[] nativeHistory = {"Traits","North American Tribes Map", "South American Tribes Map","Architecture"};

        ArrayAdapter<String> storyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nativeStory);
        ArrayAdapter<String> historyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nativeHistory);

        ListView historyList = (ListView) findViewById(R.id.nativeHistoricalList);

        ListView contextualList = (ListView) findViewById(R.id.nativeContextualList);

        historyList.setAdapter(historyAdapter);
        contextualList.setAdapter(storyAdapter);

       // final int[] storyBackgrounds = {};
       // final int[]  historyBackgrounds = {};

        final TabHost host = (TabHost)findViewById(R.id.tabHost);

        host.setup();

        //Tab History
        TabHost.TabSpec spec = host.newTabSpec("History");
        spec.setIndicator("History");
        spec.setContent(R.id.nativeHistoricalList);
        host.addTab(spec);

        //Tab Text
        spec = host.newTabSpec("Text");
        spec.setIndicator("Text");
        spec.setContent(R.id.nativeContextualList);
        host.addTab(spec);

        //Tab Connection
        spec = host.newTabSpec("Connection");
        spec.setIndicator("Connection");
        spec.setContent(R.id.connectionText);
        host.addTab(spec);


    }
    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }

}
