package com.example.cam.amlit;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by cam on 7/16/16.
 */


public class customListAdapter extends BaseAdapter {

    Context context;
    String[] names;
    int[] backgrounds;

    private static LayoutInflater inflater = null;

    public customListAdapter(Context context, String[]names,int[] backgrounds) {
        this.context = context;
        this.names = names;
        this.backgrounds = backgrounds;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null)
            view = inflater.inflate(R.layout.list_item, null);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(names[position]);

        view.setBackgroundResource(backgrounds[position]);


        return view;
    }


}