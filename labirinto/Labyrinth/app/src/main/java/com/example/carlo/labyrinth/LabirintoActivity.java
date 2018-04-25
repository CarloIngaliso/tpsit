package com.example.carlo.labyrinth;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LabirintoActivity extends AppCompatActivity {
    private Labirinto l;
    private Personaggio p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labirinto);
        l= new Labirinto(8,10,this);
        Fragment1 f1 = new Fragment1();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        int animazione = R.animator.slide_top;
        ft.setCustomAnimations(animazione, R.animator.fade);
        ft.replace(R.id.labirinto, f1);
        ft.commit();
        l.stanzaCorrente.isPlayerHere=true;
        l.stanzaCorrente.win();
        new Thread(()->runOnUiThread(() -> f1.piazzaMuri(l.stanzaCorrente))).start();
    }

    public void prova(View view){
        l.stanzaCorrente.isPlayerHere=false;
        switch(view.getId()){
            case R.id.left:
                //new Thread(() -> p.muovi(1,0)).start();
                if(l.stanzaCorrente.hasDestra()) {
                    l.stanzaCorrente = l.stanzaCorrente.getDestra();
                    Fragment1 f1 = new Fragment1();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    int animazione = R.animator.slide_out_right;
                    ft.setCustomAnimations(animazione, R.animator.fade);
                    ft.replace(R.id.labirinto, f1);
                    ft.commit();
                    new Thread(() -> runOnUiThread(() -> f1.piazzaMuri(l.stanzaCorrente))).start();
                }
                break;
            case R.id.right:
                //new Thread(() -> p.muovi(-1,0)).start();
                if(l.stanzaCorrente.hasSinistra()) {
                    l.stanzaCorrente= l.stanzaCorrente.getSinistra();
                    Fragment1 f1 = new Fragment1();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    int animazione = R.animator.slide_in_left;
                    ft.setCustomAnimations(animazione, R.animator.fade);
                    ft.replace(R.id.labirinto, f1);
                    ft.commit();
                    new Thread(()->runOnUiThread(() -> f1.piazzaMuri(l.stanzaCorrente))).start();
                }
                break;
            case R.id.down:
                //new Thread(() -> p.muovi(0,1)).start();
                if(l.stanzaCorrente.hasSotto()) {
                    l.stanzaCorrente= l.stanzaCorrente.getSotto();
                    Fragment1 f1 = new Fragment1();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    int animazione = R.animator.slide_down;
                    ft.setCustomAnimations(animazione, R.animator.fade);
                    ft.replace(R.id.labirinto, f1);
                    ft.commit();
                    new Thread(()->runOnUiThread(() -> f1.piazzaMuri(l.stanzaCorrente))).start();
                }
                break;
            case R.id.up:
                //new Thread(() -> p.muovi(0,-1)).start();
                if(l.stanzaCorrente.hasSopra()) {
                    l.stanzaCorrente= l.stanzaCorrente.getSopra();
                    Fragment1 f1 = new Fragment1();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    int animazione = R.animator.slide_top;
                    ft.setCustomAnimations(animazione, R.animator.fade);
                    ft.replace(R.id.labirinto, f1);
                    ft.commit();
                    new Thread(()->runOnUiThread(() -> f1.piazzaMuri(l.stanzaCorrente))).start();
                }
                break;
        }
        l.stanzaCorrente.isPlayerHere=true;
        l.stanzaCorrente.win();
    }

}
