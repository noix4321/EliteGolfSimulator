/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author 1667686
 */
public class RealMenu extends javax.swing.JFrame {

    /**
     * Creates new form RealMenu
     */
    public RealMenu() {
        initComponents();
        evenements();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Waddup boii");
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        jButton1.setText("Nouvelle partie...");
        jButton1.setAlignmentY(0.0F);
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 200, 110, 23);

        jButton2.setText("Options...");
        jButton2.setAlignmentY(0.0F);
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 230, 110, 23);

        jButton3.setText("Info...");
        getContentPane().add(jButton3);
        jButton3.setBounds(190, 260, 110, 23);

        jButton4.setText("Quitter");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(190, 290, 110, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\1667686\\Desktop\\Elite Golf Simulator\\EliteGolfSimulator\\allo.png")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 499, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RealMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealMenu().setVisible(true);
            }
        });
    }

    public void nouvellePartie() {
        Fenetre fen = new Fenetre();
        fen.setVisible(true);
        dispose();

    }

    public void evenements() {
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixDifficulte();
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Francis Guay, date de remise ; 15 octobre 2017", "Regles",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void choixDifficulte() {

        Object[] options = {"Debutant", "Intermediaire", "Avance", "Expert"};
        int optionPane = JOptionPane.showOptionDialog(null,
                "Choisisser une difficulté?",
                "Menu option",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[3]);

        switch (optionPane) {
            case YES_OPTION: { //option debutant du JOptionPane
                /*setLayout(null);
                setPreferredSize(new Dimension(1500, 600));
                add(monde);
                
                setVisible(true);*/
                nouvellePartie();
                System.out.println("hbveby");
            }
            break;
            case NO_OPTION: { //option intermediaire du JOptionPane

            }
            break;
            case CANCEL_OPTION: { //option avance du JOptionPane

            }
            break;
            default: { //option expert JOptionPane

            }
            break;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
