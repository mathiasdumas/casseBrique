package jeu.models;

import jeu.casseBrique;

import java.awt.*;

public class balle extends sprite {
    private int diametre;
    private int vitesseHorizontal;
    private int vitesseVertical;


    public balle(int x, int y, int diametre) {
        super(x, y, Color.RED);
        this.diametre = diametre;
        this.vitesseHorizontal = 5;
        this.vitesseVertical = 4;

    }

    public balle(int diametre) {
        super((int)(Math.random() * casseBrique.LARGEUR), (int)(Math.random() * casseBrique.HAUTEUR), new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));
        this.diametre = diametre;
        this.vitesseHorizontal = (int)(Math.random() * 5) + 2;
        this.vitesseVertical = (int)(Math.random() * 5) + 2;

    }

    public void deplacement() {
        x += vitesseHorizontal;
        y += vitesseVertical;

        if(x >= casseBrique.LARGEUR -diametre || x <= 0) {
            vitesseHorizontal = -vitesseHorizontal;
        }
        if(y >= casseBrique.HAUTEUR -diametre || y <= 0) {
            vitesseVertical = -vitesseVertical;
        }


    }

    public void renvoieBalle(){
        vitesseVertical = - vitesseVertical;
    }
    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    public int getVitesseHorizontal() {
        return vitesseHorizontal;
    }

    public void setVitesseHorizontal(int vitesseHorizontal) {
        this.vitesseHorizontal = vitesseHorizontal;
    }

    public int getVitesseVertical() {
        return vitesseVertical;
    }

    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }


    public void dessiner(Graphics2D dessin){
        dessin.setColor(couleur);
        dessin.fillOval(x, y, diametre, diametre);
    }

    public int getCentreX(){
        return x +diametre /2;
    }

    public int getCenterY(){
        return  y + diametre /2;
    }

}