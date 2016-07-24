package com.example.cam.amlit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class SecondEnglishWave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_english_wave);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TabHost host = (TabHost)findViewById(R.id.tabHost);

        final String[] secondHistory = {"Puritan Society", "Puritan Map"};
        final String[] secondContext = {"A Model of Christian Charity","The Journals of Winthrop","The Lord of Misrule"};


        ArrayAdapter<String> storyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,secondContext);
        ArrayAdapter<String> historyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,secondHistory);

        ListView historyList = (ListView) findViewById(R.id.englishSecondHistoricalList);

        ListView contextualList = (ListView) findViewById(R.id.englishSecondContextualList);

        historyList.setAdapter(historyAdapter);
        contextualList.setAdapter(storyAdapter);

        host.setup();

        //Tab History
        TabHost.TabSpec spec = host.newTabSpec("History");
        spec.setIndicator("History");
        spec.setContent(R.id.englishSecondHistoricalList);
        host.addTab(spec);

        //Tab Text
        spec = host.newTabSpec("Text");
        spec.setIndicator("Text");
        spec.setContent(R.id.englishSecondContextualList);
        host.addTab(spec);

        //Tab Connection
        spec = host.newTabSpec("Connection");
        spec.setIndicator("Connection");
        spec.setContent(R.id.englishSecondText);
        host.addTab(spec);


    }
    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
        finish();

    }
}
