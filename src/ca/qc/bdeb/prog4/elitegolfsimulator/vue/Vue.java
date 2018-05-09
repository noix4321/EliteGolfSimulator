package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ca.qc.bdeb.prog4.elitegolfsimulator.modele.Modele;
import ca.qc.bdeb.prog4.elitegolfsimulator.vue.Monde;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 1533727
 */
class Vue extends JFrame implements Observer {

    private Monde monde;
    private MondeNiveau2 mondeNiveau2;
    private Modele modele;
    private final int HAUTEUR = 600, LARGEUR = 1500;
    private JPanel pnlNord = new JPanel();
    //private JLabel lblCoups = new JLabel("Coups : " + 0);
    private JLabel lblTrou = new JLabel("Trou " + 0);
    private JMenuBar mnuBar = new JMenuBar();
    private JMenu mnuMenu = new JMenu("Menu");
    private Thread thread;
    private Golfeur golfeur = new Golfeur();
    private Balle balle = new Balle();
    private Trou trou = new Trou();
    private Drapeau drapeau = new Drapeau();
    private ArrayList<Integer> listKeyCodes = new ArrayList<>();
    private boolean bougeBalle = false, bougeLigneForce = true;
    private JMenuItem mnuDifficulté = new JMenuItem("Difficulté");
    private JMenuItem mnuRegles = new JMenuItem("Regles");
    private JMenuItem mnuNbTrous = new JMenuItem("Nombre de trous");
    private JMenuItem mnuInstructions = new JMenuItem("Instructions");
    private JMenuItem mnuNbJoueurs = new JMenuItem("Nombre de joueurs");
    private int coups = 0, trous = 1;
    private int compteur = 1;

    private Vue vue;
    private MondeNiveau2 mondeniveau2;
    private GrandArbre grandArbre = new GrandArbre();
    private Cube cube = new Cube();
    private boolean tire;
    private boolean boolGazon = true;
    private JLabel nbrCoups = new JLabel();
    private int vitesseX = 50;
    private int vitesseY = -40;
    private int gravity = 1;
    private Arc arc = new Arc();

    public Vue(Observable observable) {

        monde = new Monde();

        setTitle("Elite Golf Simulator");
        setVisible(true);
        setSize(1500, 700);
        setLayout(new BorderLayout());
        mettrePanels();
        mettreMenus();
        //mettreGolfeurTrouDrapeau();
        creerEvenements();

        modele = (Modele) observable;
        //mettreGolfeurTrouDrapeau();
        setResizable(true);
        //pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    verifierTouche();
                    if (bougeBalle) {

                        bougeLigneForce = false;
                        if (compteur % 3 == 0) {
                            balle.setLocation(balle.getVelocityX() + balle.getX(), balle.getVelocityY() + balle.getY());
                            //balle.getVelocityY() + balle.getY()
                        }
                        System.out.println(balle.getX());
                        System.out.println(balle.getY());
                        //System.out.println(trou.getY());
                        compteur++;

                        balle.VelocityGrave();
                    }

                    if (balle.getY() >= 450) {
                        balle.setVelocityY(0);
                        balle.setVelocityX(0);
                        balle.setLocation(balle.getX(), balle.getY() - 20);
                        golfeur.setLocation(balle.getX() - 100, balle.getY() - golfeur.getHeight());
                        bougeBalle = false;
                        bougeLigneForce = true;
                    }

//                    if (balle.getBounds().intersects(trou.getBounds())) {
//                        //mettreGolfeurTrouDrapeau();
//                        balle.setVelocityY(0);
//                        balle.setVelocityX(0);
//                        int reply = JOptionPane.showConfirmDialog(null, "You won! want to continue?", "close?", JOptionPane.YES_NO_OPTION);
//                        if (reply == JOptionPane.YES_OPTION) {
//                            try {
//                                Thread.sleep(60000);
//                            } catch (InterruptedException exc) {
//
//                            }
//
//                            revalidate();
//                            repaint();
//
//                        }
//                        if (reply == JOptionPane.NO_OPTION) {
//                            System.exit(0);
//                        }
//
//                    }
                    if (bougeLigneForce) {
                        if (compteur % 3 == 0) {
                            bougerLigneForce();
                        }
                    }

                    compteur++;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException exc) {

                    }
                }
            }

        };

        thread.start();
    }

    private void mettrePanels() {
        pnlNord.setLayout(new BorderLayout());
        add(pnlNord, BorderLayout.NORTH);
        add(monde);
        //pnlNord.add(lblCoups, BorderLayout.WEST);
        pnlNord.add(lblTrou, BorderLayout.EAST);
    }

    public void mettrepaneaux() {
        //getContentPane().remove();
        pnlNord.setLayout(new BorderLayout());
        add(pnlNord, BorderLayout.NORTH);
        add(mondeNiveau2);
        //pnlNord.add(lblCoups, BorderLayout.WEST);
        pnlNord.add(lblTrou, BorderLayout.EAST);
        validate();
        repaint();
    }

    private void creerEvenements() {
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (!listKeyCodes.contains(e.getKeyCode())) {
                    listKeyCodes.add(e.getKeyCode());

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                listKeyCodes.remove(new Integer(e.getKeyCode()));
            }
        });

        mnuInstructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Appuyer une première fois sur la touche espace pour choisir la force de votre"
                        + "frappe, puis une deuxième fois pour ajuster l'angle de votre frappe.", "Instructions",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        mnuRegles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Le but du jeu est d'enoyer la balle dans le trou en la frappant le moins de fois possible. "
                        + "La parabole de votre balle varie en fonction du type de bâton choisi. Prenez garde au vent!", "Règles",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        mnuDifficulté.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Debutant", "Intermediaire", "Avance", "Expert"};
                int optionPane = JOptionPane.showOptionDialog(null,
                        "Choisisser une difficulté?",
                        "Menu option",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
            }
        });
    }

    private void mettreMenus() {
        setJMenuBar(mnuBar);
        mnuBar.add(mnuMenu);
        mnuMenu.add(mnuDifficulté);
        mnuMenu.add(mnuInstructions);
        mnuMenu.add(mnuRegles);
        mnuMenu.addSeparator();
        mnuMenu.add(mnuNbJoueurs);
        mnuMenu.add(mnuNbTrous);

    }

    private void calculerForce(int force) {

        if (balle.getX() > (trou.getX() - 300)) {
            balle.setVelocityY(0);
            balle.setGravity(0);
        } else {
            balle.setVelocityY(-40);
        }

        int forceBarre = 0;
        if (force <= 15) {
            forceBarre = 1;
        } else if (force <= 34) {
            forceBarre = 2;
        } else if (force <= 55) {
            forceBarre = 3;
        } else if (force <= 78) {
            forceBarre = 4;
        } else if (forceBarre <= 104) {
            forceBarre = 5;
        } else {
            forceBarre = 6;
        }
        balle.setVelocityX(forceBarre * 5);
    }

    private void verifierTouche() {
        if (listKeyCodes.contains(KeyEvent.VK_SPACE)) {
            monde.getLigneForce().setPosX(monde.getLigneForce().getX());
            calculerForce(monde.getLigneForce().getPosX());
//            monde.getLigneForce().setPosY(monde.getLigneForce().getY());
//            System.out.println(monde.getLigneForce().getPosX() + " - " + monde.getLigneForce().getPosY());
            System.out.println(golfeur.getY());
//            balle.resetVelocitys();
            frapperBall();
        }

    }

    private void frapperBall() {
        bougeBalle = true;
    }

    private void bougerLigneForce() {

        monde.getLigneForce().bouger();

        if ((monde.getLigneForce().getX() + monde.getLigneForce().getWidth()) >= (monde.getBarre().getX() + monde.getBarre().getWidth())) {
            monde.getLigneForce().setDeltaX(monde.getLigneForce().getDeltaX() * -1);
        }
        if (monde.getLigneForce().getX() <= monde.getBarre().getX()) {
            monde.getLigneForce().setDeltaX(monde.getLigneForce().getDeltaX() * -1);
        }
        monde.getLigneForce().setLocation(monde.getLigneForce().getPosX(), monde.getLigneForce().getY());
        validate();
        repaint();
    }

    private void mettreGolfeurTrouDrapeau() {;
        add(monde.getLigneForce());
        monde.getLigneForce().setLocation(5, HAUTEUR - monde.getLigneForce().getHeight() - 5);
        add(monde.getBarre());
        monde.getBarre().setLocation(5, HAUTEUR - monde.getBarre().getHeight() - 5);
    }

    @Override
    public void update(Observable o, Object arg) {
        Modele modele = (Modele) o;
        coups = monde.getCoups();
        monde.getnbrCoups().setText("Points: " + coups);

    }

}
