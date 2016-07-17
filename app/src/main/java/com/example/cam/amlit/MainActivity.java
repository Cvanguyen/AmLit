package com.example.cam.amlit;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity{
        //implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] names = { "First Nations","First Encounters", "First English Wave",
                "Second English Wave", "Witch Trials"};

        final int[] backgrounds = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};

        ListView list = (ListView) findViewById(R.id.list_view);
        customListAdapter adapter = new customListAdapter(this,names,backgrounds);//,backgroundIds);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0: //first nation
                        Intent nationIntent = new Intent(MainActivity.this,NativeAmericans.class);
                        startActivity(nationIntent);
                        finish();
                        break;
                    case 1: //first encounters
                        Intent encounterIntent = new Intent(MainActivity.this,FirstEncounters.class);
                        startActivity(encounterIntent);
                        break;
                    case 2: //first english
                        Intent englishIntent = new Intent(MainActivity.this,FirstEnglishWave.class);
                        startActivity(englishIntent);
                        break;
                    case 3: //second english
                        Intent secondIntent = new Intent(MainActivity.this,SecondEnglishWave.class);
                        startActivity(secondIntent);
                        break;
                    case 4: //witch trials
                        Intent witchIntent = new Intent(MainActivity.this,WitchTrials.class);
                        startActivity(witchIntent);
                        break;
                }


            }

        });


    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
