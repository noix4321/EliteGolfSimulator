/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author 1533727
 */
public class Golfeur extends JComponent{

     Image img = getToolkit().getDefaultToolkit().getImage("golfeur.gif");
    
    public Golfeur() {
        setSize(134, 106);
    }
    
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.drawImage(img, 0, 0, this);
    }
    
}
