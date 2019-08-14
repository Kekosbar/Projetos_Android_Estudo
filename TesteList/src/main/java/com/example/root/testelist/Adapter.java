package com.example.root.testelist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Item> {

    private final Activity context;
    private ArrayList<Item> item;

    public Adapter(Activity context, ArrayList<Item> item) {
        super(context, R.layout.mylist, item);

        this.context = context;
        this.item = item;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txt = (TextView) rowView.findViewById(R.id.txtListComum);

        txt.setText(item.get(position).getItem());
        return rowView;
    };
}
