package com.example.root.mensagem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import script.Mensagem;

public class ListAdaptador extends ArrayAdapter<Mensagem>{

    private final Activity content;
    private ArrayList<Mensagem> item;

    public ListAdaptador(Activity content, ArrayList<Mensagem> item) {
        super(content, R.layout.mylist, item);
        this.content = content;
        this.item = item;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = content.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView txtNome = (TextView) rowView.findViewById(R.id.nome);
        TextView txtHora = (TextView) rowView.findViewById(R.id.hora);
        TextView txtMsm = (TextView) rowView.findViewById(R.id.msm);

        txtNome.setText(item.get(position).getNomeContato());
        txtMsm.setText(item.get(position).getMsm());
        txtHora.setText(item.get(position).getHora());

        return rowView;
    }
}
