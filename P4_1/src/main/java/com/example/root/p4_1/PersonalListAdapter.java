package com.example.root.p4_1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonalListAdapter extends ArrayAdapter<ItemList>{

    private ArrayList<ItemList> lista;
    private final Activity context;

    public PersonalListAdapter(Activity context, ArrayList<ItemList> lista) {
        super(context, R.layout.mylist, lista);

        this.context = context;
        this.lista = lista;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView txtItem = (TextView) rowView.findViewById(R.id.txtCurso);
        CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkBox);

        txtItem.setText(lista.get(position).getNameItem());
        checkBox.setChecked(lista.get(position).isCheck());

        return rowView;
    }
}
