/*
File Name:	startMenu 
Programmer:	Shreyas Krishna Prasad
Date:		July 26th, 2017
Description:	This program is a connect 4 iteration named "Connect 4 Success." This game 
                has the same rules as connect-4 but is single player; there are 2 difficulties to choose from: easy and hard. 
 */
package pkgfinal.project;
//import libraries required
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class startMenu extends javax.swing.JFrame {

    public startMenu() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        difficultyGroup = new javax.swing.ButtonGroup();
        title = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        namePrompt = new javax.swing.JLabel();
        difficultyPrompt = new javax.swing.JLabel();
        easy = new javax.swing.JRadioButton();
        hard = new javax.swing.JRadioButton();
        loadSavedGamePrompt = new javax.swing.JLabel();
        gameIDPrompt = new javax.swing.JLabel();
        startGame = new javax.swing.JButton();
        startGamePrompt = new javax.swing.JLabel();
        gameID = new javax.swing.JTextField();
        loadGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameLoadGame = new javax.swing.JLabel();
        nameUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setForeground(new java.awt.Color(153, 153, 255));

        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/c4stitle.png"))); // NOI18N
        getContentPane().setBackground(new Color(225,109,107));

        namePrompt.setText("Enter your name: ");

        difficultyPrompt.setText("Difficulty");

        difficultyGroup.add(easy);
        easy.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        easy.setText("Easy");

        difficultyGroup.add(hard);
        hard.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        hard.setText("Hard");

        loadSavedGamePrompt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loadSavedGamePrompt.setText("Load Saved Game: ");

        gameIDPrompt.setText("Enter gameID: ");

        startGame.setBackground(new java.awt.Color(0, 0, 0));
        startGame.setForeground(new java.awt.Color(255, 255, 255));
        startGame.setText("Start Game");
        startGame.setBorderPainted(false);
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });

        startGamePrompt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        startGamePrompt.setText("Start New Game: ");

        loadGame.setBackground(new java.awt.Color(0, 0, 0));
        loadGame.setForeground(new java.awt.Color(255, 255, 255));
        loadGame.setText("Load Game");
        loadGame.setBorderPainted(false);
        loadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameActionPerformed(evt);
            }
        });

        jLabel1.setText("by Shreyas Krishna Prasad");

        nameLoadGame.setText("and name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(difficultyPrompt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(startGamePrompt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(namePrompt)
                        .addGap(18, 18, 18)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(startGame))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(gameIDPrompt)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadSavedGamePrompt)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gameID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameLoadGame)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(loadGame)))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(easy, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(startGamePrompt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namePrompt)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(difficultyPrompt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(easy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startGame)
                .addGap(30, 30, 30)
                .addComponent(loadSavedGamePrompt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameIDPrompt)
                    .addComponent(gameID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLoadGame)
                    .addComponent(nameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //this method is called when the "start game" button is clicked, it checks for valid information then proceeds to gameScreen
    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameActionPerformed
        if (name.getText() == null || name.getText().equals("")) {//check if name is empty string or null
            JOptionPane.showMessageDialog(null, "Please enter a name");//tell user to enter name
        } else if (!easy.isSelected() && !hard.isSelected()) {//tell user to select difficulty if they haven't 
            JOptionPane.showMessageDialog(null, "Please select a difficulty");
        } else {
            createPlayer();//call method to initalize player details
        }
    }//GEN-LAST:event_startGameActionPerformed

    //this method is called when the "load game" button is clicked, it loads an existing instance of the game
    private void loadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameActionPerformed
        //check for both gameID and player  name
        if ((gameID.getText() != null && !gameID.getText().equals("")) && (nameUser.getText() != null && !nameUser.getText().equals(""))) {
            checkGame(gameID.getText() + " " + nameUser.getText());//call method to check for game with parameter being the gameID and name
        } else {//tell user to enter both fields before loading game
            JOptionPane.showMessageDialog(null, "Please enter a valid game ID and the corresponding player name.");
        }
    }//GEN-LAST:event_loadGameActionPerformed

    //this method checks for an existing saved game by retrieving a text file with a predetermined naming convention
    private void checkGame(String identification) {
        String line;//to store information from current line of text in game file 
        int counter = 1;//to keep track of current line 
        try {
            FileReader fileReader
                    = new FileReader(identification + ".txt");//read file using parameter as name 
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {//while another line exists
                if (counter == 1) {//if current line is 1, set difficulty to line 
                    difficulty = line;
                } else if (counter == 2) {//if current line is 2, set oldTurns to line 
                    oldTurns = Integer.parseInt(line);
                } else if (counter == 3) {//if current line is 3, set oldTime to line 
                    oldTime = Integer.parseInt(line);
                } else if (counter == 4) {//if current line is 4, set oldGame to line 
                    oldGame = line;
                } else {
                    if (counter == 5) {//if current line is greater or equal to 5, initialize oldLog, and set it's values
                        oldLog = new String[oldTurns];
                    }
                    oldLog[counter - 5] = line;//to start at index 0 and increase by 1 every time counter is greater than 5
                }
                counter++;//increment counter
            }
            //close buffered reader after file is completely read
            bufferedReader.close();
            playerName = nameUser.getText();//set playername to name entered by user since game is validated
            playergameID = Integer.parseInt(gameID.getText());//set playerID to ID entered by user since game is validated
            switchScreens();//call method to proceed to gamescreen
        } catch (FileNotFoundException ex) {//if file isn't found, display prompt
            JOptionPane.showMessageDialog(null, identification + " could not be found.");
        } catch (IOException ex) {//if file cannot be read, display prompt
            JOptionPane.showMessageDialog(null, identification + " could not be read.");
        }
    }

    //static variables to store player data (can be accessed by all other classes)
    //oldGame is set to "empty" as default to indicate if game was loaded 
    static String playerName, difficulty, oldGame = "empty", oldLog[];
    static int playergameID, oldTurns = 0, oldTime;

    //this method creates a player profile
    private void createPlayer() {
        String difficultySelected = "Easy";//default difficulty

        if (!easy.isSelected()) {//is easy isn't selected, difficulty set to hard
            difficultySelected = "Hard";
        }

        playerName = name.getText();//set player name 
        difficulty = difficultySelected;//set difficulty to local variable 
        playergameID = (int) (Math.random() * 10000) + 1;//generate playergameID to random value from 1 to 10000

        switchScreens();//call method to proceed to gameScreen 
    }

    private void switchScreens() {
        this.dispose();//destroy current screen
        gameScreen gS = new gameScreen();//initialize gameScreen
        gS.setVisible(true);//make gameScreen visible 

        //display jDialog component during screen transition, according to chosen difficulty 
        if (difficulty.equals("Easy")) {
            gS.timeDescription.setText("In easy difficulty, you have unlimited time to move.");
        } else {
            gS.timeDescription.setText("In hard difficulty, you have 10 seconds to move.");
        }
        //set visibility of prompt to true 
        gS.continuePrompt.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(startMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(startMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(startMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(startMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new startMenu().setVisible(true);
            }
        });
    }
//all variables named according to camelCase notation
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup difficultyGroup;
    private javax.swing.JLabel difficultyPrompt;
    private javax.swing.JRadioButton easy;
    private javax.swing.JTextField gameID;
    private javax.swing.JLabel gameIDPrompt;
    private javax.swing.JRadioButton hard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loadGame;
    private javax.swing.JLabel loadSavedGamePrompt;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLoadGame;
    private javax.swing.JLabel namePrompt;
    private javax.swing.JTextField nameUser;
    private javax.swing.JButton startGame;
    private javax.swing.JLabel startGamePrompt;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
