/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator.modele;

import java.util.Observable;

/**
 *
 * @author 1667686
 */
public class Modele extends Observable {

    private int coups = 0;

    public void coup(int coupsDePlus) {
        coups = coups + coupsDePlus;
        System.out.println(coups);
        changer();
    }
    
    public int getCoups(){
        return coups;
    }
    
    public void setCoups(int coups){
        coups=this.coups;
    }
    private void changer() {
        setChanged();
        notifyObservers();
    }
}
