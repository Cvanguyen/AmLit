package com.example.cam.amlit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class NativeAmericans extends AppCompatActivity {

    final String[] nativeStory = {"Codices","Newspaper Rock","Hopi Myths"};
    final String[] nativeHistory = {"General Traits","North American Tribes Map","Architecture","Perceptions"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_americans);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayAdapter<String> storyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nativeStory);
        ArrayAdapter<String> historyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nativeHistory);

        ListView historyList = (ListView) findViewById(R.id.nativeHistoricalList);

        ListView contextualList = (ListView) findViewById(R.id.nativeContextualList);

        historyList.setAdapter(historyAdapter);
        contextualList.setAdapter(storyAdapter);


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

        historyList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:// General Traits
                        final AlertDialog alertDialog = new AlertDialog.Builder(NativeAmericans.this).create();
                        alertDialog.setTitle("General Shared Traits");
                        alertDialog.setMessage("Respect for the Elderly\n A System of Trade \n Tradition of Oral History \n Intimate Relationship with Nature");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        break;
                    case 1://map of terroitys
                        //Creates a layout with the imageview and custom layout
                        final Dialog mapDialog = new Dialog(NativeAmericans.this);
                        mapDialog.setContentView(R.layout.image_dialog);
                        mapDialog.setTitle("North American Nations");
                        ImageView image = (ImageView) mapDialog.findViewById(R.id.image);
                        image.setImageResource(R.drawable.tribalmap);
                        mapDialog.show();
                        break;
                    case 2:

                        break;
                    case 3:
                        final AlertDialog perceptionsDialog = new AlertDialog.Builder(NativeAmericans.this).create();
                        perceptionsDialog.setTitle("European Perceptions");
                        perceptionsDialog.setMessage("\tThe majority of the European explorers consider the Native Americans to be savages, but some in the minority lived amongst them and come appreciate their culture.");
                        perceptionsDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        perceptionsDialog.show();

                        break;
                }


            }

        });

        contextualList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:// General Traits
                        final AlertDialog alertDialog = new AlertDialog.Builder(NativeAmericans.this).create();
                        alertDialog.setTitle("General Shared Traits");
                        alertDialog.setMessage("Respect for the Elderly\n A System of Trade \n Tradition of Oral History \n Intimate Relationship with Nature");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        break;
                    case 1://map of terroitys
                        //Creates a layout with the imageview and custom layout
                        final Dialog mapDialog = new Dialog(NativeAmericans.this);
                        mapDialog.setContentView(R.layout.image_dialog);
                        mapDialog.setTitle("North American Nations");
                        ImageView image = (ImageView) mapDialog.findViewById(R.id.image);
                        image.setImageResource(R.drawable.tribalmap);
                        mapDialog.show();
                        break;
                    case 2:

                        break;

                }


            }

        });


    }
    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }


}
