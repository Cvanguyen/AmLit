package com.example.cam.amlit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class WitchTrials extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_witch_trials);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TabHost host = (TabHost)findViewById(R.id.tabHost);

        final String[] witchHistory = {"Overview"};
        final String[] witchText = {"Speech to the General Court"};


        ArrayAdapter<String> storyAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,witchText);
        ArrayAdapter<String> historyAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,witchHistory);

        ListView historyList = (ListView) findViewById(R.id.witchHistoricalList);

        ListView contextualList = (ListView) findViewById(R.id.witchContextualList);

        historyList.setAdapter(historyAdapter);
        contextualList.setAdapter(storyAdapter);

        host.setup();

        //Tab Witch History
        TabHost.TabSpec spec = host.newTabSpec("History");
        spec.setIndicator("History");
        spec.setContent(R.id.witchHistoricalList);
        host.addTab(spec);

        //Tab Witch text
        spec = host.newTabSpec("Text");
        spec.setIndicator("Text");
        spec.setContent(R.id.witchContextualList);
        host.addTab(spec);

        //Tab Witch Connection
        spec = host.newTabSpec("Connection");
        spec.setIndicator("Connection");
        spec.setContent(R.id.witchText);
        host.addTab(spec);



    }
    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }

}
