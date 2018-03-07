package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ca.qc.bdeb.prog4.elitegolfsimulator.modele.Modele;
import ca.qc.bdeb.prog4.elitegolfsimulator.vue.Monde;
import java.awt.BorderLayout;
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
import javax.swing.JPanel;

/**
 *
 * @author 1533727
 */
class Vue extends JFrame implements Observer {

    private Monde monde;
    private Modele modele;
    private JPanel pnlNord = new JPanel();
    //private JLabel lblCoups = new JLabel("Coups : " + 0);
    private JLabel lblTrou = new JLabel("Trou " + 0);
    private JMenuBar mnuBar = new JMenuBar();
    private JMenu mnuMenu = new JMenu("Menu");
    private ArrayList<Integer> listKeyCodes = new ArrayList<>();
    private JMenuItem mnuDifficulté = new JMenuItem("Difficulté");
    private JMenuItem mnuRegles = new JMenuItem("Regles");
    private JMenuItem mnuNbTrous = new JMenuItem("Nombre de trous");
    private JMenuItem mnuInstructions = new JMenuItem("Instructions");
    private JMenuItem mnuNbJoueurs = new JMenuItem("Nombre de joueurs");
    private int coups = 0;

    public Vue(Observable observable) {

        monde = new Monde(listKeyCodes);
        setTitle("Elite Golf Simulator");
        setVisible(true);
        setLayout(new BorderLayout());
        mettrePanels();
        mettreMenus();

        creerEvenements();

        modele = (Modele) observable;

        setResizable(false);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void mettrePanels() {
        pnlNord.setLayout(new BorderLayout());
        add(pnlNord, BorderLayout.NORTH);
        add(monde);
        //pnlNord.add(lblCoups, BorderLayout.WEST);
        pnlNord.add(lblTrou, BorderLayout.EAST);
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

    @Override
    public void update(Observable o, Object arg) {
        Modele modele = (Modele) o;
        coups = monde.getCoups();
        monde.getnbrCoups().setText("Points: " + coups);

    }

}
