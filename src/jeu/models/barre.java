package jeu.models;

import jeu.casseBrique;

import java.awt.*;

public class barre extends rectangle {

    protected int vitesse = 9;

    public barre() {
        super(0, casseBrique.HAUTEUR - 100, Color.BLUE, 200, 20);
        this.x = casseBrique.LARGEUR / 2 - this.largeur / 2;
    }



    public void deplacerGauche(){
        if(x > 0) {
            x -= vitesse;
        }
    }

    public void deplacerDroite(){
        if((x < casseBrique.LARGEUR - this.largeur)){
            x += vitesse;
        }
    }
}
