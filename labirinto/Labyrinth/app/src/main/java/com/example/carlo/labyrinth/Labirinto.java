package com.example.carlo.labyrinth;

import android.app.Activity;

import java.util.Random;



public class Labirinto {
    protected Stanza[][] labirinto;
    public Stanza stanzaCorrente;
    private Activity activity;
    private Random rand;

    public Labirinto(int righe, int colonne,Activity activity) {
        labirinto = new Stanza[righe][colonne];
        rand = new Random();
        this.activity=activity;
        generaLabirinto();
    }

    private void generaLabirinto(){
        for(int i=0; i< labirinto.length;i++){
            for(int j=0; j<labirinto[i].length;j++){
                if(labirinto[i][j]==null)
                    labirinto[i][j]= new Stanza(activity.findViewById(R.id.labirinto));
                if(j-1>=0){
                    if(rand.nextBoolean()) {
                        labirinto[i][j].setSopra((labirinto[i][j-1] == null) ? labirinto[i][j - 1] = new Stanza(activity.findViewById(R.id.labirinto)) : labirinto[i][j - 1]);
                        labirinto[i][j-1].setSotto(labirinto[i][j]);
                        labirinto[i][j].links++;
                        labirinto[i][j-1].links++;
                    }
                }
                if(i-1>=0){
                    if(rand.nextBoolean()) {
                        labirinto[i][j].setSinistra((labirinto[i - 1][j] == null) ? labirinto[i - 1][j] = new Stanza(activity.findViewById(R.id.labirinto)) : labirinto[i - 1][j]);
                        labirinto[i-1][j].setDestra(labirinto[i][j]);
                        labirinto[i][j].links++;
                        labirinto[i-1][j].links++;
                    }
                }
                if(j+1<labirinto.length){
                    if(rand.nextBoolean()) {
                        labirinto[i][j].setSotto((labirinto[i][j+1]==null)?labirinto[i][j+1]= new Stanza(activity.findViewById(R.id.labirinto)):labirinto[i][j+1]);
                        labirinto[i][j+1].setSopra(labirinto[i][j]);
                        labirinto[i][j].links++;
                        labirinto[i][j+1].links++;
                    }
                }
                if(i+1<labirinto.length){
                    if(rand.nextBoolean()) {
                        labirinto[i][j].setDestra((labirinto[i + 1][j] == null) ? labirinto[i + 1][j] = new Stanza(activity.findViewById(R.id.labirinto)) : labirinto[i + 1][j]);
                        labirinto[i+1][j].setSinistra(labirinto[i][j]);
                        labirinto[i][j].links++;
                        labirinto[i+1][j].links++;
                    }
                }
            }
        }
        stanzaCorrente= labirinto[new Random().nextInt(labirinto.length-1)][new Random().nextInt(labirinto.length-1)];
        while(stanzaCorrente.hasLinks()==false)
            stanzaCorrente= labirinto[new Random().nextInt(labirinto.length-1)][new Random().nextInt(labirinto.length-1)];
        setFine(stanzaCorrente,labirinto.length/2+new Random().nextInt(labirinto.length/2));
    }

    public void setFine(Stanza inizio,int passi) {
        if(passi>0) {
            boolean muoviX = new Random().nextBoolean();
            if (muoviX == true) {
                if (inizio.hasDestra() && inizio.hasSinistra()) {
                    if (new Random().nextBoolean())
                        setFine(inizio.getSinistra(), passi - 1);
                    else
                        setFine(inizio.getDestra(), passi - 1);
                } else if (inizio.hasDestra()) {
                    setFine(inizio.getDestra(), passi - 1);
                } else if (inizio.hasSinistra()) {
                    setFine(inizio.getSinistra(), passi - 1);
                }
            } else if (muoviX == false || (!inizio.hasDestra() && !inizio.hasSinistra())) {
                if (inizio.hasSopra() && inizio.hasSotto()) {
                    if (new Random().nextBoolean())
                        setFine(inizio.getSopra(), passi - 1);
                    else
                        setFine(inizio.getSotto(), passi - 1);
                } else if (inizio.hasSopra()) {
                    setFine(inizio.getSopra(), passi - 1);
                } else if (inizio.hasSotto()) {
                    setFine(inizio.getSotto(), passi - 1);
                }
            }
        }else if(!inizio.isInizio()){
            inizio.setIsFine(true);
        }else{
            setFine(inizio,4);
        }

    }
}