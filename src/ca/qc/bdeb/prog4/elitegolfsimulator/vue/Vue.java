package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ca.qc.bdeb.prog4.elitegolfsimulator.modele.Modele;
import ca.qc.bdeb.prog4.elitegolfsimulator.vue.Monde;
import java.awt.BorderLayout;
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

    public Vue(Observable observable, int number) {
        switch (number) {
            case 1:
                monde = new Monde(listKeyCodes);
                break;
            case 2:
                mondeNiveau2 = new MondeNiveau2(listKeyCodes);                
                break;
            default:

        }
        monde = new Monde(listKeyCodes);

        setTitle("Elite Golf Simulator");
        setVisible(true);
        setLayout(new BorderLayout());
        mettrePanels();
        mettreMenus();

        creerEvenements();

        modele = (Modele) observable;

        setResizable(true);
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
    
    public void mettrepaneaux(){
        getContentPane().removeAll();
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

    @Override
    public void update(Observable o, Object arg) {
        Modele modele = (Modele) o;
        coups = monde.getCoups();
        monde.getnbrCoups().setText("Points: " + coups);

    }

}
