package jeu.models;

import java.awt.*;

public class rectangle extends sprite {


    protected int largeur;
    protected int hauteur;

    public rectangle(int x, int y, Color couleur, int largeur, int hauteur) {
        super(x, y, couleur);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(x, y, largeur, hauteur);
    }

    public boolean collision (balle balle) {

        // si la balle touche la barre
        return balle.getCentreX() >= x
                && balle.getCentreX() <= x + largeur
                && balle.getCenterY() > y - balle.getDiametre()
                && balle.getCenterY() <= y + hauteur;
    }


}
