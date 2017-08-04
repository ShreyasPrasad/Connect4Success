/*
File Name:	gameOverScreen
Programmer:	Shreyas Krishna Prasad
Date:		July 26th, 2017
Description:	This program is a connect 4 iteration named "Connect 4 Success." This game 
                has the same rules as connect-4 but is single player; there are 2 difficulties to choose from: easy and hard. 
 */
package pkgfinal.project;

import java.awt.Color;
import javax.swing.JLabel;

public class gameOverScreen extends javax.swing.JFrame {

    public gameOverScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        winner = new javax.swing.JLabel();
        returntoMenu = new javax.swing.JButton();
        gameDetails = new javax.swing.JLabel();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        winner.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        winner.setHorizontalAlignment(JLabel.CENTER);
        winner.setText("Winner: XXXXXX");
        getContentPane().setBackground(new Color(225,107,109));

        returntoMenu.setBackground(new java.awt.Color(0, 0, 0));
        returntoMenu.setForeground(new java.awt.Color(255, 255, 255));
        returntoMenu.setText("Return to Main Menu");
        returntoMenu.setBorderPainted(false);
        returntoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returntoMenuActionPerformed(evt);
            }
        });

        gameDetails.setHorizontalAlignment(JLabel.CENTER);
        gameDetails.setText("Game Time: X:XX                 Number of Moves: 0");

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/happyface.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(image))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(returntoMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(winner))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(gameDetails)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(winner)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(image)
                .addGap(18, 18, 18)
                .addComponent(gameDetails)
                .addGap(24, 24, 24)
                .addComponent(returntoMenu)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //this method is called when the "return to menu" button is clicked and disposes the current screen 
    private void returntoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returntoMenuActionPerformed
      //destroy current screen and return to startMenu, setting it visible 
      this.dispose();
      startMenu menu=new startMenu();
      menu.setVisible(true);
    }//GEN-LAST:event_returntoMenuActionPerformed

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
            java.util.logging.Logger.getLogger(gameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gameOverScreen().setVisible(true);
            }
        });
    }
//all variables named according to camelCase notation
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel gameDetails;
    public javax.swing.JLabel image;
    private javax.swing.JButton returntoMenu;
    public javax.swing.JLabel winner;
    // End of variables declaration//GEN-END:variables
}
