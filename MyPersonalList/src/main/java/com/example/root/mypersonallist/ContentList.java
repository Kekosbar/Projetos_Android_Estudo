package com.example.root.mypersonallist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ContentList extends ArrayAdapter<String>{

    private final Activity context;
    private Item item;

    public ContentList(Activity context, Item item) {
        super(context, R.layout.mylist, item.name);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.item = item;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtName = (TextView) rowView.findViewById(R.id.txt1);
        TextView txtNumber = (TextView) rowView.findViewById(R.id.txt2);
        TextView txtMSM = (TextView) rowView.findViewById(R.id.txtMSM);
        CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkbox);
        this.item.checkBox.add(checkBox);

        txtName.setText(item.name.get(position));
        txtNumber.setText(item.number.get(position));
        txtMSM.setText(item.msm.get(position));
        return rowView;

    };
}
