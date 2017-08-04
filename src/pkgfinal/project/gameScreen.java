/*
File Name:	gameScreen
Programmer:	Shreyas Krishna Prasad
Date:		July 26th, 2017
Description:	This program is a connect 4 iteration named "Connect 4 Success." This game 
                has the same rules as connect-4 but is single player; there are 2 difficulties to choose from: easy and hard. 
 */
package pkgfinal.project;
//import necessary libraries 
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class gameScreen extends javax.swing.JFrame {

    public gameScreen() {
        initComponents();
    }
    /*create JLabel array manually and set all their icons to the default empty grid square,
    place game grid in a panel, set background colour of JFrame to custom RGB using java.awt.Color, create
    invisible buttons above each column of jLabel grid squares so the user can select where they want to place a piece
    */
    public JLabel gameGrid[][];
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        continuePrompt = new javax.swing.JDialog();
        toGame = new javax.swing.JButton();
        timeDescription = new javax.swing.JLabel();
        gameGridPanel = new javax.swing.JPanel();
        col1 = new javax.swing.JButton();
        col2 = new javax.swing.JButton();
        col3 = new javax.swing.JButton();
        col4 = new javax.swing.JButton();
        col5 = new javax.swing.JButton();
        col6 = new javax.swing.JButton();
        col7 = new javax.swing.JButton();
        optionsPanel = new javax.swing.JPanel();
        namePrompt = new javax.swing.JLabel();
        gameIDPrompt = new javax.swing.JLabel();
        mainMenuButton = new javax.swing.JButton();
        saveGameButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameMoves = new javax.swing.JTextArea();
        turn = new javax.swing.JLabel();
        difficultyPrompt = new javax.swing.JLabel();
        elaspedTime = new javax.swing.JLabel();
        timeTurn = new javax.swing.JLabel();
        instruction = new javax.swing.JLabel();

        continuePrompt.setLocationRelativeTo(null);
        continuePrompt.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        continuePrompt.setTitle("Timer Notification");
        continuePrompt.setBackground(new Color (225,109,107));
        continuePrompt.setMinimumSize(new java.awt.Dimension(400, 120));

        toGame.setActionCommand("-1");
        toGame.addActionListener(handleEvents);
        toGame.setBackground(new java.awt.Color(0, 0, 0));
        toGame.setForeground(new java.awt.Color(255, 255, 255));
        toGame.setText("Continue");
        toGame.setBorderPainted(false);

        getContentPane().setBackground(new Color (225,107,109));
        timeDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        timeDescription.setText("Time Description");

        javax.swing.GroupLayout continuePromptLayout = new javax.swing.GroupLayout(continuePrompt.getContentPane());
        continuePrompt.getContentPane().setLayout(continuePromptLayout);
        continuePromptLayout.setHorizontalGroup(
            continuePromptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(continuePromptLayout.createSequentialGroup()
                .addGroup(continuePromptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(continuePromptLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(toGame))
                    .addGroup(continuePromptLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(timeDescription)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        continuePromptLayout.setVerticalGroup(
            continuePromptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, continuePromptLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(timeDescription)
                .addGap(18, 18, 18)
                .addComponent(toGame)
                .addGap(36, 36, 36))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(225,107,109));
        gameGridPanel.setLayout(new java.awt.GridLayout(6, 7));
        gameGrid=new JLabel[6][7];
        for (int i=0;i<6; i++){
            for (int t=0;t<7; t++){
                gameGrid[i][t]=new JLabel();
                gameGrid[i][t].setIcon(pieceEmpty);
                gameGridPanel.add(gameGrid[i][t]);
            }
        }

        col1.addActionListener(handleEvents);
        col1.setActionCommand("1");
        col1.setBorderPainted(false);
        col1.setContentAreaFilled(false);

        col2.addActionListener(handleEvents);
        col2.setActionCommand("2");
        col2.setBorderPainted(false);
        col2.setContentAreaFilled(false);

        col3.addActionListener(handleEvents);
        col3.setActionCommand("3");
        col3.setBorderPainted(false);
        col3.setContentAreaFilled(false);

        col4.addActionListener(handleEvents);
        col4.setActionCommand("4");
        col4.setBorderPainted(false);
        col4.setContentAreaFilled(false);

        col5.addActionListener(handleEvents);
        col5.setActionCommand("5");
        col5.setBorderPainted(false);
        col5.setContentAreaFilled(false);

        col6.addActionListener(handleEvents);
        col6.setActionCommand("6");
        col6.setBorderPainted(false);
        col6.setContentAreaFilled(false);

        col7.addActionListener(handleEvents);
        col7.setActionCommand("7");
        col7.setBorderPainted(false);
        col7.setContentAreaFilled(false);

        optionsPanel.setBackground(new java.awt.Color(255, 255, 255));

        namePrompt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        namePrompt.setText("Player: "+startMenu.playerName);

        gameIDPrompt.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        gameIDPrompt.setText("Game ID: "+startMenu.playergameID);

        mainMenuButton.setActionCommand("100");
        mainMenuButton.addActionListener(handleEvents);
        mainMenuButton.setBackground(new java.awt.Color(0, 0, 0));
        mainMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        mainMenuButton.setText("Main Menu");

        saveGameButton.setActionCommand("101");
        saveGameButton.addActionListener(handleEvents);
        saveGameButton.setBackground(new java.awt.Color(0, 0, 0));
        saveGameButton.setForeground(new java.awt.Color(255, 255, 255));
        saveGameButton.setText("Save Game");

        gameMoves.setEditable(false);
        gameMoves.setColumns(20);
        gameMoves.setRows(5);
        jScrollPane1.setViewportView(gameMoves);

        turn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        turn.setText("It's "+startMenu.playerName+"'s turn.");

        difficultyPrompt.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        difficultyPrompt.setText("Difficulty: "+startMenu.difficulty);

        elaspedTime.setText("Game Time:");

        timeTurn.setText("Turn Time: ");

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(namePrompt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(difficultyPrompt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(gameIDPrompt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(mainMenuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveGameButton))
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(elaspedTime)
                            .addComponent(turn)
                            .addComponent(timeTurn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(namePrompt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameIDPrompt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(difficultyPrompt)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(turn)
                .addGap(18, 18, 18)
                .addComponent(timeTurn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(elaspedTime)
                .addGap(18, 18, 18)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainMenuButton)
                    .addComponent(saveGameButton))
                .addContainerGap())
        );

        instruction.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        instruction.setText("Click above the column you wish to drop a piece in.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(col1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(col3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(col4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(col5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(col6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(col7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gameGridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(instruction)
                        .addGap(188, 188, 188)))
                .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(col1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(col3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(col4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(col5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(col6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(col7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameGridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(instruction))
            .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //handle all gameScreen events in gameLogic class, set all actionListener values to handleEvents
    gameLogic handleEvents=new gameLogic(this);
    //imageicons for all possible game pieces: empty piece, player piece, and computer piece
    ImageIcon pieceEmpty=new ImageIcon(getClass().getResource("/pkgfinal/project/e.jpg"));
    ImageIcon piecePlayer=new ImageIcon(getClass().getResource("/pkgfinal/project/r.jpg"));
    ImageIcon pieceComputer=new ImageIcon(getClass().getResource("/pkgfinal/project/o.jpg"));
                    
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
            java.util.logging.Logger.getLogger(gameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gameScreen().setVisible(true);
            }
        });
    }
//all variables named according to camelCase notation 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton col1;
    private javax.swing.JButton col2;
    private javax.swing.JButton col3;
    private javax.swing.JButton col4;
    private javax.swing.JButton col5;
    private javax.swing.JButton col6;
    private javax.swing.JButton col7;
    public javax.swing.JDialog continuePrompt;
    private javax.swing.JLabel difficultyPrompt;
    public javax.swing.JLabel elaspedTime;
    private javax.swing.JPanel gameGridPanel;
    private javax.swing.JLabel gameIDPrompt;
    public javax.swing.JTextArea gameMoves;
    private javax.swing.JLabel instruction;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JLabel namePrompt;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JButton saveGameButton;
    public javax.swing.JLabel timeDescription;
    public javax.swing.JLabel timeTurn;
    public javax.swing.JButton toGame;
    public javax.swing.JLabel turn;
    // End of variables declaration//GEN-END:variables
}
