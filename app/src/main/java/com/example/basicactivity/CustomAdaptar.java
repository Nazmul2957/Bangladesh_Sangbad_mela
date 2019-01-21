package com.example.basicactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptar extends BaseAdapter {



    Context c;
    ArrayList<Model> models;

    public CustomAdaptar(Context c, ArrayList<Model> spacecrafts) {
        this.c = c;
        this.models = spacecrafts;
    }



    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.gridview_model,parent,false);
        }

        final Model s= (Model) this.getItem(position);

        ImageView imageView= (ImageView) convertView.findViewById(R.id.image);
        TextView text= (TextView) convertView.findViewById(R.id.text);

        //BIND
        text.setText(s.getName());
        imageView.setImageResource(s.getImage());
        return convertView;
    }
}
