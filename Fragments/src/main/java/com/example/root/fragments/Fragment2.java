package com.example.root.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup content, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.frag2, null);

        TextView txt = (TextView) view.findViewById(R.id.txtFrag2);
        txt.setText("Fragment 2");

        return view;
    }

    public void alteraTxt(String texto){
        TextView txt = (TextView) getView().findViewById(R.id.txtFrag2);
        txt.setText(texto);
    }

}
