package com.example.cam.amlit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class FirstEncounters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_encounters);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] history = {"Class Interpretation", "Bartholome De la Casas", "De 7Vaca", "Diaz"};
        final String[] text = {"Short Account of the Destruction of the Indies"};


        ArrayAdapter<String> storyAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,text);
        ArrayAdapter<String> historyAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,history);

        ListView historyList = (ListView) findViewById(R.id.firstHistoricalList);

        ListView contextualList = (ListView) findViewById(R.id.firstContextualList);

        historyList.setAdapter(historyAdapter);
        contextualList.setAdapter(storyAdapter);

        final TabHost host = (TabHost)findViewById(R.id.tabHost);

        host.setup();

        //Tab History
        TabHost.TabSpec spec = host.newTabSpec("History");
        spec.setIndicator("History");
        spec.setContent(R.id.firstHistoricalList);
        host.addTab(spec);

        //Tab Text
        spec = host.newTabSpec("Text");
        spec.setIndicator("Text");
        spec.setContent(R.id.firstContextualList);
        host.addTab(spec);

        //Tab Connections
        spec = host.newTabSpec("Connection");
        spec.setIndicator("Connection");
        spec.setContent(R.id.firstText);
        host.addTab(spec);

    }
    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }

}
