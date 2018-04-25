/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author 1667686
 */
public class MondeNiveau2 extends Monde {

    //public ArrayList<Integer> listKeyCodes = new ArrayList<>();

    public MondeNiveau2(ArrayList listKeyCodes) {
        super(listKeyCodes);
        

    }
    
    
    
//    public Monde(ArrayList listKeyCodes) {
//
//        this.listKeyCodes = listKeyCodes;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.red);
        g.drawRect(50, 50, 50, 50);
        
        
    }

}
