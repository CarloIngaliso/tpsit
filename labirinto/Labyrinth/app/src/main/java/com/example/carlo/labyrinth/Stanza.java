package com.example.carlo.labyrinth;

import android.content.Intent;
import android.widget.FrameLayout;



class Stanza {
    private FrameLayout stanza;
    private boolean isFine = false,isInizio = false;
    private Stanza sinistra,destra,sopra,sotto;
    public int links;
    public boolean isPlayerHere;

    public Stanza(FrameLayout stanza){
        this.stanza=stanza;
    }

    public Stanza getSinistra(){
        return this.sinistra;
    }

    public Stanza getDestra(){
        return this.destra;
    }

    public Stanza getSopra(){
        return this.sopra;
    }

    public Stanza getSotto(){
        return this.sotto;
    }

    public void setSinistra(Stanza stanza){
        this.sinistra=stanza;
    }

    public void setDestra(Stanza stanza){
        this.destra=stanza;
    }

    public void setSopra(Stanza stanza){
        this.sopra=stanza;
    }

    public void setSotto(Stanza stanza){
        this.sotto=stanza;
    }

    public boolean hasSinistra(){
        return !(this.sinistra==null);
    }

    public boolean hasDestra(){
        return !(this.destra==null);
    }

    public boolean hasSopra(){
        return !(this.sopra==null);
    }

    public boolean hasSotto(){
        return !(this.sotto==null);
    }

    public boolean hasLinks(){
        return !((this.sopra==null) && (this.sotto==null) && (this.destra==null) && (this.sinistra==null));
    }

    public void setIsFine(boolean isFine) {
        this.isFine = isFine;
    }

    public void setIsInizio(boolean isInizio) {
        this.isInizio = isInizio;
    }

    public boolean isInizio(){
        return isInizio;
    }

    public void win(){
        if(isPlayerHere && isFine){
            System.out.println("Fine raggiunta.");
            stanza.getContext().startActivity(new Intent(stanza.getContext(),HaiVinto.class));
        }
    }

}