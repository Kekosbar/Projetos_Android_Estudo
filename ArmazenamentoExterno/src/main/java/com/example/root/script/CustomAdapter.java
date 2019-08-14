package com.example.root.script;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import script.Pasta;

public class CustomAdapter extends ArrayAdapter<String>{

    private Activity activity;
    //private Pasta pasta;
    private ArrayList<String> array;

    public CustomAdapter(Activity activity, ArrayList<String> array){
        super(activity, R.layout.mylist, array);
        this.activity = activity;
        this.array = array;
        //this.pasta = pasta;
    }

    public View getView(int position, View view, ViewGroup group){
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView textView = (TextView) rowView.findViewById(R.id.textNamePastaMyList);

        textView.setText(array.get(position));
        return rowView;
    }

}
