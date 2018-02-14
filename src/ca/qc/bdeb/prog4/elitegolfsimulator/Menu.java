/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.JPanel;

/**
 *
 * @author 1533727
 */
public class Menu extends JPanel{

    private Image img1 = getToolkit().getDefaultToolkit().getImage("photoMenu.jpg");
    private Monde monde = new Monde();
   
    
    public Menu() {
        final int LARGEUR = monde.getLARGEUR();
        final int HAUTEUR = monde.getHAUTEUR();
        setLayout(null);
        setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
    }
    
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//       
//        g.drawImage(img1, 0, 0, this);
//
//    }

    protected void choixDifficulte() {
        
        Object[] options = {"Débutant", "Intermédiaire", "Expert", "Hard en tabarnack"};
                int optionPane = JOptionPane.showOptionDialog(null,
                        "Choisisser une difficulté?",
                        "Menu option",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[3]);

                switch (optionPane) {
                    case YES_OPTION: { //option 7x7 du JOptionPane
                        
                    }
                    break;
                    case NO_OPTION: { //option 6x6 du JOptionPane
                        
                    }
                    break;
                    case CANCEL_OPTION: { //option 5x5 du JOptionPane
                       
                    }
                    break;
                    default: { //option 4x4 du JOptionPane
                       
                    }
                    break;
                }
        
    }
    
    
    
}
