package jeu.models;

import java.awt.*;

public abstract class sprite {

    protected int x;
    protected int y;
    protected Color couleur;

    abstract public void dessiner(Graphics2D dessin);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public sprite(int x, int y, Color couleur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }
}
