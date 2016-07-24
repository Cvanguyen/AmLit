package com.example.cam.amlit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class FirstEnglishWave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_english_wave);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TabHost host = (TabHost)findViewById(R.id.tabHost);

        final String[]  history = {"Myths", "Jamestown Map"};
        final String[]  context = {"John Smith's Writing"};

        ArrayAdapter<String> storyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,context);
        ArrayAdapter<String> historyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,history);

        ListView historyList = (ListView) findViewById(R.id.firstEnglishHistoricalList);

        ListView contextualList = (ListView) findViewById(R.id.firstEnglishContextualList);

        historyList.setAdapter(historyAdapter);
        contextualList.setAdapter(storyAdapter);

        host.setup();

        //Tab History
        TabHost.TabSpec spec = host.newTabSpec("History");
        spec.setIndicator("History");
        spec.setContent(R.id.firstEnglishHistoricalList);
        host.addTab(spec);

        //Tab Text
        spec = host.newTabSpec("Text");
        spec.setIndicator("Text");
        spec.setContent(R.id.firstEnglishContextualList);
        host.addTab(spec);

        //Tab Connections
        spec = host.newTabSpec("Connection");
        spec.setIndicator("Connection");
        spec.setContent(R.id.firstEnglishText);
        host.addTab(spec);


    }
    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }

}
