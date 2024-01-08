package jeu;

import jeu.models.balle;
import jeu.models.barre;
import jeu.models.brique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class casseBrique extends Canvas implements KeyListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 600;
    protected ArrayList<balle> listeBalle = new ArrayList<>();
    protected ArrayList<brique> listeBrique = new ArrayList<>();
    protected ArrayList<brique> SupprBrique = new ArrayList<>();
    protected jeu.models.barre barre = new barre();


    public static void main(String[] args) {

        new casseBrique();

    }
    public casseBrique() {

        JFrame fenetre = new JFrame();

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0,0, LARGEUR, HAUTEUR);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        fenetre.pack();
        fenetre.setSize(LARGEUR, HAUTEUR);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);

        Container panneau = fenetre.getContentPane();
        panneau.add(this);


        fenetre.setVisible(true);
        this.createBufferStrategy(2);
        demarrer();


    }



    public void demarrer() {


        for (int i = 0; i < 1; i++) {
            listeBalle.add(new balle(20));
        }

        int Xdecalage = 0;
        int Ydecalage = 0;
        for (int i = 0; i < 10; i++) {
            Xdecalage = 0;
            for (int j = 0; j < 5; j++) {
                listeBrique.add(new brique(Xdecalage, Ydecalage, Color.BLUE, LARGEUR / 5, 20));
                Xdecalage += LARGEUR / 5 + 2;
            }
            Ydecalage += 22;
        }





        // créer 5 x 10 briques
        // alimenter arraylist brique


        while(true) {

            try {

                Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

                dessin.setColor(Color.WHITE);
                dessin.fillRect(0,0, LARGEUR, HAUTEUR);

                for (brique brique : listeBrique){
                    brique.dessiner(dessin);
                };



                barre.dessiner(dessin);



                for (balle balle : listeBalle) {
                    balle.dessiner(dessin);
                    balle.deplacement();


                    int compteur = 0;
                    for (brique brique : listeBrique) {
                        if (brique.collision(balle)) {
                            SupprBrique.add(brique);
                            compteur++;
                            balle.setVitesseVertical(-balle.getVitesseVertical());
                        }
                    }


                    for (brique brique : SupprBrique){
                        listeBrique.remove(brique);
                    }

                    // pour chaque brique tester la collision
                    // stocker dans une liste les briques impactées
                    // après le foreach des briques, supprimes les briques impactées
                    // pcq on ne peut pas supprimer un element d'une liste alors qu'on parcourt cette liste

                    if (barre.collision(balle)) {
                        balle.setVitesseVertical(-balle.getVitesseVertical());
                    }

                    if (compteur == 50){
                        System.out.println("tu as gagné");
                    }
                }


                dessin.dispose();
                this.getBufferStrategy().show();

                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                System.out.println("processus arreté");
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 37){                   // quand la touche gauche est enfoncée
            barre.deplacerGauche();

        } else if (e.getKeyCode() == 39){           // quand la touche droite est enfoncée
            barre.deplacerDroite();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}