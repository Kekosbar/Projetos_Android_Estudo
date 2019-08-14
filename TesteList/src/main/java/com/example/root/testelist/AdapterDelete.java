package com.example.root.testelist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDelete extends ArrayAdapter<Item> {

    private final Activity context;
    private ArrayList<Item> item;

    public AdapterDelete(Activity context, ArrayList<Item> item) {
        super(context, R.layout.mylistdelete, item);

        this.context = context;
        this.item = item;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylistdelete, null,true);

        TextView txt = (TextView) rowView.findViewById(R.id.txtListDelete);
        CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkBox);

        checkBox.setChecked(item.get(position).isCheck());
        txt.setText(item.get(position).getItem());
        return rowView;
    };
}