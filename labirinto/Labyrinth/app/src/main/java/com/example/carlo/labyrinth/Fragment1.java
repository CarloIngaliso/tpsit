package com.example.carlo.labyrinth;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
    View view;
    Personaggio p;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment, container, false);
        p= new Personaggio(view);
        return view;
    }

    public void piazzaMuri(Stanza stanza){
        if(stanza.hasDestra()){
            view.findViewById(R.id.muroDestro).setVisibility(View.INVISIBLE);
        }
        if(stanza.hasSinistra()){
            view.findViewById(R.id.muroSinistro).setVisibility(View.INVISIBLE);
        }
        if(stanza.hasSotto()){
            view.findViewById(R.id.muroBasso).setVisibility(View.INVISIBLE);
        }
        if(stanza.hasSopra()){
            view.findViewById(R.id.muroAlto).setVisibility(View.INVISIBLE);
        }
    }

}