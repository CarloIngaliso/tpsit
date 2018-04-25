package com.example.carlo.labyrinth;

import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;



public class Personaggio {
    protected float life=50f;
    protected float speed=2f;
    protected float attack=5f;
    private ImageView pgImage;
    private View view;
    private Point altoDestra,altoSinistra,bassoDestra,bassoSinsitra;


    Personaggio(View view){
        this.view=view;
        this.life=life;
        this.speed=speed;
        this.attack=attack;
        pgImage=view.findViewById(R.id.personaggio);
        altoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
        altoSinistra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
        bassoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
        bassoSinsitra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
    }

    public void muovi(int versoX,int versoY){
        if(versoX>0){
            float estremoX= this.view.findViewById(R.id.labirinto).getY()+60+170;
            if(estremoX>this.getX()+pgImage.getWidth()/2){
                pgImage.setX(pgImage.getX()+10);
                altoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
                altoSinistra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
                bassoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
                bassoSinsitra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
            }
        }else if(versoX<0){
            float estremoX= this.view.findViewById(R.id.labirinto).getY()+60;
            if(estremoX<this.getX()){
                pgImage.setX(pgImage.getX()-10);
                altoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
                altoSinistra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
                bassoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
                bassoSinsitra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
            }
        }else if(versoY>0){
            float estremoY= this.view.findViewById(R.id.labirinto).getY()+60+170;
            if(estremoY>this.getY()-pgImage.getHeight()/2){
                pgImage.setY(pgImage.getY()+10);
                altoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
                altoSinistra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
                bassoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
                bassoSinsitra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
            }
        }else if(versoY<0){
            float estremoY= this.view.findViewById(R.id.labirinto).getY()+60;
            if(estremoY<this.getY()+pgImage.getHeight()/2){
                pgImage.setY(pgImage.getY()-10);
                altoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
                altoSinistra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()-pgImage.getHeight()/2);
                bassoDestra= new Point(this.getX()+pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
                bassoSinsitra= new Point(this.getX()-pgImage.getWidth()/2,this.getY()+pgImage.getHeight()/2);
            }

        }
    }

    public int getX(){
        return (int)pgImage.getX()+pgImage.getWidth()/2;
    }

    public int getY(){
        return (int)pgImage.getY()+pgImage.getHeight()/2;
    }

}
