package pkgfinal.project;
//import all libraries for timer, actionlisten, JOptionPane, and filewriter

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class gameLogic implements ActionListener {

    //global variables that handle program logic
    gameScreen events;//instance of game screen
    public int numTurns = startMenu.oldTurns;//set number of turns to oldTurns, if old instance of game is loaded
    boolean moveLegal = false, isComputerTurn = false;//handle the user's ability to move
    int pieceTypes[][] = new int[6][7];//array to store type of piece in each square of grid 
    int currentTime = 10, elapsedSeconds = 0;//for game time, and move time
    int currentI, currentT;//storing computer's current possible move (for hard difficulty)
    boolean canCallAgain = true;//to prevent win condition from being called twice if a win has already been detected

    public gameLogic(gameScreen instance) {
        events = instance;//initialize game screen 
    }

    @Override
    //method is called to handle interactions on the game screen
    public void actionPerformed(ActionEvent e) {
        //using actionCommands set for buttons in gameScreen 
        int command = Integer.parseInt(e.getActionCommand());//all actionCommands are integers 
        if (command > 0 && command < 8 && moveLegal) {//for row of buttons that handle the player's move 
            placePiece(Integer.parseInt(e.getActionCommand()) - 1);//call method to place piece
            moveLegal = false;//set moveLegal to false, disabling button clicks until computer has moved
            if (canCallAgain) {//if they win after move, don't request computer response
                isComputerTurn = true;
                computerResponse();
            }
        } else if (command == 100) {//for button to return to main menu
            mainMenu();
        } else if (command == 101) {//for button to save game
            if (moveLegal) {//if it's the user turn, save the game
                saveGame();//call method to save the game 
                JOptionPane.showMessageDialog(null, "Game was saved successfully");
            } else {//if it's the computer's turn 
                JOptionPane.showMessageDialog(null, "Game can only be saved during your turn.");
            }

        } else if (command == -1) {//for the prompt displayed to the user when they exit the menu and the game screen is initialized
            moveLegal = true;
            checkOldGame();//call method to check for game
            handleTime();//call method to handle time for chosen difficulty
            elapsedTime();//call method to initialize game time
            events.continuePrompt.dispose();//destroy prompt and continue to game 
        }
    }

    //this method is called when the user makes a move
    private void placePiece(int col) {
        boolean lastPiece = false;
        int row = 5;
        //loop to determine if column that the user chose is empty, and if so, place it in the next available empty grid square 
        while (!lastPiece) {
            if (pieceTypes[row][col] == 0) {
                pieceTypes[row][col] = 1;
                events.gameGrid[row][col].setIcon(events.piecePlayer);//if square identified, set piece to player piece
                lastPiece = true;
                logPiece(col, 1);//call method to record move 
            } else if (row == 0) {
                lastPiece = true;
            } else {
                row--;
            }
        }
        int outcome = checkWin();//call method to check for winning condition 
        if (outcome != 0) {
            handleWin(outcome);//if win is detected, call method to handle accordingly 
        } else {
            isTie();//check if game is tie 
        }
    }

    //method to switch to main menu
    private void mainMenu() {
        events.dispose();
        startMenu menu = new startMenu();
        menu.setVisible(true);
    }

    //metthod to handle timer for chosen difficulty
    private void handleTime() {
        if (startMenu.difficulty.equals("Easy")) {//for easy, unlimited time
            events.timeTurn.setText("Time for turn: Unlimited");
        } else {
            startTimer();//for hard, call method startTimer for 10 second move time
        }
    }

    //this method implements a timer usr java.util.Timer. the timer replaces the text of a timer JLabel every second to indicate time left to move
    private void startTimer() {

        Timer turntimer = new Timer();

        TimerTask updateLabel = new TimerTask() {

            @Override
            public void run() {
                if (currentTime != 0 && !isComputerTurn) {//when move time isn't 0 and it isn't computer's turn 
                    events.timeTurn.setText("Time for turn: " + currentTime);
                    currentTime--;
                }
                //if it is computer turn or player's time has expired, reset jLabel and show dialog 
                if (currentTime == 0 || isComputerTurn) {
                    moveLegal = false;
                    cancel();//cancel timer 
                    events.timeTurn.setText("Time for turn: 10");
                    if (currentTime == 0 && !isComputerTurn) {
                        if (canCallAgain) {//if winning condition has not been achieved yet and player has run out of time
                            JOptionPane.showMessageDialog(null, "You ran out of time");
                            computerResponse();//computer moves
                        }
                    }
                    currentTime = 10;//reset time value 
                }
            }

        };
        turntimer.scheduleAtFixedRate(updateLabel, 0, 1000);//schedule timer 
    }

    //this method uses a timer to keep track of game time 
    private void elapsedTime() {
        Timer elapsed = new Timer();

        TimerTask indicateTime = new TimerTask() {

            @Override
            public void run() {
                elapsedSeconds++;//every second, total number of seconds (elapsedTime), is incremented
                if (elapsedSeconds % 60 < 10) {//if number of seconds is less than 10, add a 0 before displaying seconds
                    events.elaspedTime.setText("Game Time: " + elapsedSeconds / 60 + ":0" + elapsedSeconds % 60);
                } else {//if number of seconds is greater or equal to 10, format normally 
                    events.elaspedTime.setText("Game Time: " + elapsedSeconds / 60 + ":" + elapsedSeconds % 60);
                }
            }

        };
        elapsed.schedule(indicateTime, 0, 1000);//schedule timer
    }

    //this method saves the game using a BufferedWriter to create a text file
    private void saveGame() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(startMenu.playergameID + " " + startMenu.playerName + ".txt"));
            createGameProfile(out);//call method to write player profile and game details to text file 
            out.close();//close new file
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating game log, try again.");
        }
    }

    //this method creates a game profile to write to text file, all info is on a new line      
    private void createGameProfile(BufferedWriter out) {
        try {
            out.write(startMenu.difficulty);//first line is game difficulty 
            out.newLine();
            out.write(numTurns + "");//second line is number of turns played in current instance of game 
            out.newLine();
            out.write(elapsedSeconds + "");//third line is game time in seconds 
            out.newLine();
            for (int i = 0; i < 6; i++) {//writes the gamegrid array to a single line
                for (int t = 0; t < 7; t++) {
                    out.append(pieceTypes[i][t] + "");
                }
            }
            out.newLine();
            //writes the game log in textArea to multiple lines 
            for (String line : events.gameMoves.getText().split("\\n")) {
                out.write(line);
                out.newLine();
            }

            out.close();//close new file 
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error creating game log, try again.");
        }
    }

    //this method checks if an old game is being loaded, and if so, set's the pieceTypes array to the stored game grid, and updates the textArea with the moves already played. 
    private void checkOldGame() {
        if (!startMenu.oldGame.equals("empty")) {//check if game is being loaded 
            for (int i = 0; i < 6; i++) {
                for (int t = 0; t < 7; t++) {
                    pieceTypes[i][t] = Character.getNumericValue(startMenu.oldGame.charAt((i * 7) + t));
                    if (pieceTypes[i][t] == 1) {
                        events.gameGrid[i][t].setIcon(events.piecePlayer);
                    } else if (pieceTypes[i][t] == 2) {
                        events.gameGrid[i][t].setIcon(events.pieceComputer);
                    }
                }
            }
            elapsedSeconds = startMenu.oldTime;//retrieve old game time
            for (int t = 0; t < numTurns; t++) {
                events.gameMoves.append(startMenu.oldLog[t] + "\n");
            }
        }
    }

    //this method updates the record of moves to the textArea, dependong on who has moved
    private void logPiece(int col, int turn) {//col parameter is for column selected, and turn identifies either player or computer
        numTurns++;//increment number of turns
        if (turn == 1) {
            events.gameMoves.append("Turn: " + numTurns + " - " + startMenu.playerName + " placed a piece in column " + (col + 1) + ".\n");
        } else {
            events.gameMoves.append("Turn: " + numTurns + " - " + "The computer placed a piece in column " + (col + 1) + ".\n");
        }
    }

    //this method checks for a win in the current game grid by considering vertical, horizontal, and diagonal orientations
    private int checkWin() {
        if (checkVertical(false) != 0) {
            return checkVertical(false);
        } else if (checkHorizontal(false) != 0) {
            return checkHorizontal(false);
        } else if (checkDiagonal(false) != 0) {
            return checkDiagonal(false);
        } else {
            return 0;//if no win condition found, return, 0
        }
    }

    //this method handles a winning outcome by disposing of the gameScreen, and switching to the gameOverScreen
    private void handleWin(int outcome) {
        if (canCallAgain) {
            events.dispose();
            isComputerTurn = true;
            currentTime = 10;
            gameOverScreen gOS = new gameOverScreen();
            switch (outcome) {//depending on outcome, display winner message and change picture 
                case 1:
                    gOS.winner.setText(startMenu.playerName + " Won!");//for player win outcome
                    break;
                case 2:
                    gOS.image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/compface.png")));
                    gOS.winner.setText("The computer won!");//for computer win outcome
                    break;
                default:
                    gOS.winner.setText("Tie Game!");//for tie win outcome
                    gOS.image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/tiegame.png")));
                    break;
            }
            //output game details 
            gOS.gameDetails.setText(events.elaspedTime.getText() + "          Number of moves: " + numTurns);
            gOS.setVisible(true);
            canCallAgain = false;
        }
    }

    //this method is called for the computer's response sequence, when either the user has moved or run out of time 
    private void computerResponse() {
        events.turn.setText("Computer's turn");
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        if (startMenu.difficulty.equals("Easy")) {//for easy difficulty, call corresponding method 
                            easyComp();
                        } else {//for hard difficulty, call corresponding method
                            hardComp();
                        }
                        int outcome = checkWin();//check if win condition has been satisifed after computer move
                        if (outcome != 0) {
                            handleWin(outcome);
                        } else {
                            isTie();//check if game is tied 
                        }
                        events.turn.setText("It's " + startMenu.playerName + "'s turn");//indicate it's player's turn again
                        moveLegal = true;
                        isComputerTurn = false;
                        handleTime();//restart move timer if necessary 
                    }
                },
                3000//computer turn takes 3 seconds 
        );

    }

    //method to handle easy computer 
    private void easyComp() {
        boolean colNotFound = true;
        while (colNotFound) {
            int randomCol = (int) (Math.random() * 7);//places a piece in an available random location (column)
            boolean lastPiece = false;
            int row = 5;
            while (!lastPiece) {
                if (pieceTypes[row][randomCol] == 0) {
                    pieceTypes[row][randomCol] = 2;
                    events.gameGrid[row][randomCol].setIcon(events.pieceComputer);//if square is valid, set square icon to computer piece
                    lastPiece = true;
                    colNotFound = false;
                    logPiece(randomCol, 2);//call method to record move 
                } else if (row == 0) {
                    lastPiece = true;
                } else {
                    row--;
                }
            }
        }
    }

    /*method to handle hard computer, This method determines if the computer can block or complete a combination of 4
     pieces and then move accordingly. Given more time, the hard computer would have been perfected.*/
    private void hardComp() {
        int verticalResponse = checkVertical(true), horizontalResponse = checkHorizontal(true);

        if (verticalResponse != 0 || horizontalResponse != 0) {
            computerMove();//call method for computer move to block/complete vertical or linear row of 4 pieces.
        } else {
            int diagonalResponse = checkDiagonal(true);
            if (diagonalResponse != 0 && pieceTypes[currentT + 1][currentI] != 0) {
                computerMove();//call method for computer move to block/complete diagonal row of pieces.
            } else {
                easyComp();//if no practical moves found, move randomly 
            }
        }

    }

    //this method makes an intelligent move for the computer and records it 
    private void computerMove() {
        events.gameGrid[currentT][currentI].setIcon(events.pieceComputer);//set icon to computer piece
        pieceTypes[currentT][currentI] = 2;
        logPiece(currentI, 2);//record move
    }

    //the following method checks if the game result is a tie, and if it is, calls the handleWin method to proceed to the next screen accordingly
    private void isTie() {
        if (numTurns == 42)//if 42 moves have been played, representing the number of game grid squares, the handleWin method is called with parameter 3
        {
            handleWin(3);
        }
    }

    //this method checks all columns for groups of 4 pieces of the same type or groups of 3 pieces (for the computer's next move)
    private int checkVertical(boolean isComputer) {
        /*nested for loops check all the columns and increment the number of each type of piece (1 or 2). If 4 or 3 in a row is achieved,
         the appropriate value is returned depending on the isComputer parameter. */
        int counterPv = 0, counterCv = 0;//counters for piece of each type 
        for (int i = 0; i < 7; i++) {
            for (int t = 0; t < 6; t++) {
                if (pieceTypes[t][i] == 1) {
                    counterPv++;//for consecutive player pieces
                    counterCv = 0;//set number of computer pieces to 0
                } else if (pieceTypes[t][i] == 2) {
                    counterCv++;//for consecutive computer pieces
                    counterPv = 0;//set number of player pieces to 0
                } else {
                    counterPv = 0;//for empty grid squares, reset values 
                    counterCv = 0;
                }

                if (isComputer) {
                    if (t > 2) {
                        if ((counterPv == 3 || counterCv == 3)) {
                            if (pieceTypes[t - 3][i] == 0) {
                                currentT = t - 3;
                                currentI = i;
                                return 3;
                            }
                        }
                    }
                } else {
                    if (counterPv == 4) {//for 4 consecutive player pieces, return 1 
                        return 1;
                    } else if (counterCv == 4) {//for 4 consecutive computer pieces, return 2 
                        return 2;
                    }
                }
            }
            counterPv = 0;//for next column, reset values
            counterCv = 0;
        }
        return 0;
    }

    //this method checks all rows for groups of 4 pieces of the same type or groups of 3 pieces (for the computer's next move)
    private int checkHorizontal(boolean isComputer) {
        /*the logic below is difficult to comment throrughly. Explained simply, it checks all rows for a group of either 3 or 4 pieces of the same type,
         returning the appropriate non-zero value depending on if a win condition is being checked, or the computer is seeking an intelligent move.
         The incrementing feature to detect consecutive pieces of the same type is identical to the checkVertical method */
        int counterPh = 0, counterCh = 0;//counters for piece of each type 
        for (int i = 0; i < 6; i++) {
            for (int t = 0; t < 7; t++) {
                if (pieceTypes[i][t] == 1) {
                    counterPh++;//for consecutive player pieces
                    counterCh = 0;//set number of computer pieces to 0
                } else if (pieceTypes[i][t] == 2) {
                    counterCh++;//for consecutive computer pieces
                    counterPh = 0;//set number of player pieces to 0
                } else {
                    counterPh = 0;//for empty grid squares, reset values 
                    counterCh = 0;
                }
                if (isComputer) {
                    if (counterPh == 3 || counterCh == 3) {
                        if ((t + 1) < 7 && (i + 1) < 7) {
                            if (i != 5) {
                                if (pieceTypes[i + 1][t + 1] != 0 && pieceTypes[i][t + 1] == 0) {
                                    currentT = i;
                                    currentI = t + 1;
                                    return 3;
                                }
                            } else {
                                if (pieceTypes[i][t + 1] == 0) {
                                    currentT = i;
                                    currentI = t + 1;
                                    return 3;
                                }
                            }
                        }
                        if ((t - 3) >= 0 && ((i + 1) < 7)) {
                            if (i != 5) {
                                if (pieceTypes[i + 1][t - 3] != 0) {
                                    if (pieceTypes[i][t - 3] == 0) {
                                        currentT = i;
                                        currentI = t - 3;
                                        return 3;
                                    }
                                }
                            } else {
                                if (pieceTypes[i][t - 3] == 0) {
                                    currentT = i;
                                    currentI = t - 3;
                                    return 3;
                                }
                            }
                        }
                    }
                } else {
                    if (counterPh == 4) {//for 4 consecutive player pieces, return 1 
                        return 1;
                    } else if (counterCh == 4) {//for 4 consecutive computer pieces, return 2 
                        return 2;
                    }
                }
            }
            counterPh = 0;//for next row, reset values
            counterCh = 0;
        }
        return 0;
    }

    //this method checks all diagonals for groups of 4 pieces of the same type or groups of 3 pieces (for the computer's next move)
    private int checkDiagonal(boolean isComputer) {
        /*this method detects consecutive diagonal pieces by using the last and first row as reference points to traverse the entire grid*/
        for (int i = 0; i < 7; i++) {
            boolean notAtEnd = true;
            int counterL = 0, counterR = 0;
            int counterPdr = 0, counterCdr = 0, counterPdl = 0, counterCdl = 0;//counters for piece of each type and direction
            while (notAtEnd) {
                if ((counterR < 6 && (i + counterR) < 7) || (counterL < 6 && (i - counterL) > -1)) {
                    if (counterR < 6 && (i + counterR) < 7) {
                        if (pieceTypes[counterR][i + counterR] == 1) {
                            counterPdr++;
                            counterCdr = 0;
                        } else if (pieceTypes[counterR][i + counterR] == 2) {
                            counterCdr++;
                            counterPdr = 0;
                        } else {
                            counterPdr = 0;
                            counterCdr = 0;
                        }
                    }
                    if (counterL < 6 && (i - counterL) > -1) {
                        if (pieceTypes[counterL][i - counterL] == 1) {
                            counterPdl++;
                            counterCdl = 0;
                        } else if (pieceTypes[counterL][i - counterL] == 2) {
                            counterCdl++;
                            counterPdl = 0;
                        } else {
                            counterPdl = 0;
                            counterCdl = 0;
                        }
                    }
                    if (isComputer) {
                        if (counterPdr == 3 || counterCdr == 3) {
                            if ((counterR + 1) < 6 && (i + counterR + 1) < 7) {
                                if (pieceTypes[counterR + 1][i + counterR + 1] == 0) {
                                    currentT = counterR + 1;
                                    currentI = i + counterR + 1;
                                    return 3;
                                }
                            }
                            if ((counterR - 3) > -1 && (i + (counterR - 3)) > -1 && (i + (counterR - 3)) < 7) {
                                if (pieceTypes[counterR - 3][i + (counterR - 3)] == 0) {
                                    currentT = counterR - 3;
                                    currentI = i + (counterR - 3);
                                    return 3;
                                }
                            }
                        } else if (counterPdl == 3 || counterCdl == 3) {
                            if ((counterL + 1) < 6 && (i - (counterL + 1)) > -1 && (i - (counterL + 1)) < 7) {
                                if (pieceTypes[counterL + 1][i - (counterL + 1)] == 0) {
                                    currentT = counterL + 1;
                                    currentI = i - (counterL + 1);
                                    return 3;
                                }
                            }
                            if ((counterL - 3) > -1 && (i - (counterL - 3)) > -1 && (i - (counterL - 3)) < 7) {
                                if (pieceTypes[counterL - 3][i - (counterL - 3)] == 0) {
                                    currentT = counterL - 3;
                                    currentI = i - (counterL - 3);
                                    return 3;
                                }
                            }
                        }

                    } else {
                        if (counterPdr == 4 || counterPdl == 4) {
                            return 1;
                        } else if (counterCdr == 4 || counterCdl == 4) {
                            return 2;
                        }
                    }
                    counterR++;
                    counterL++;
                } else {
                    notAtEnd = false;
                }
            }
            notAtEnd = true;
            counterL = 0;
            counterR = 0;
            counterPdr = 0;
            counterCdr = 0;
            counterPdl = 0;
            counterCdl = 0;
            while (notAtEnd) {
                if ((counterR > -1 && (i + counterR) < 7) || (counterL > -1 && (i - counterL) > -1)) {
                    if ((5 - counterR) > -1 && (i + counterR) < 7) {
                        if (pieceTypes[5 - counterR][i + counterR] == 1) {
                            counterPdr++;
                            counterCdr = 0;
                        } else if (pieceTypes[5 - counterR][i + counterR] == 2) {
                            counterCdr++;
                            counterPdr = 0;
                        } else {
                            counterPdr = 0;
                            counterCdr = 0;
                        }
                    }
                    if ((5 - counterL) > -1 && (i - counterL) > -1) {
                        if (pieceTypes[5 - counterL][i - counterL] == 1) {
                            counterPdl++;
                            counterCdl = 0;
                        } else if (pieceTypes[5 - counterL][i - counterL] == 2) {
                            counterCdl++;
                            counterPdl = 0;
                        } else {
                            counterPdl = 0;
                            counterCdl = 0;
                        }
                    }
                    if (isComputer) {
                        if (counterPdr == 3 || counterCdr == 3) {
                            if ((5 - (counterR + 1)) > -1 && (5 - (counterR + 1)) < 6 && (i + counterR + 1) < 7) {
                                if (pieceTypes[5 - (counterR + 1)][i + counterR + 1] == 0) {
                                    currentT = 5 - (counterR + 1);
                                    currentI = i + counterR + 1;
                                    return 3;
                                }
                            }
                            if ((5 - (counterR - 3)) > -1 && (5 - (counterR - 3)) < 6 && (i + (counterR - 3)) < 7) {
                                if (pieceTypes[5 - (counterR - 3)][i + (counterR - 3)] == 0) {
                                    currentT = 5 - (counterR - 3);
                                    currentI = i + (counterR - 3);
                                    return 3;
                                }
                            }
                        } else if (counterPdl == 3 || counterCdl == 3) {
                            if ((5 - (counterL + 1)) > -1 && (5 - (counterL + 1)) < 6 && (i - (counterL + 1)) > -1) {
                                if (pieceTypes[5 - (counterL + 1)][i - (counterL + 1)] == 0) {
                                    currentT = 5 - (counterL + 1);
                                    currentI = i - (counterL + 1);
                                    return 3;
                                }
                            }
                            if ((5 - (counterL - 3)) > -1 && (5 - (counterL - 3)) < 6 && (i - (counterL - 3)) > -1) {
                                if (pieceTypes[5 - (counterL - 3)][i - (counterL - 3)] == 0) {
                                    currentT = 5 - (counterL - 3);
                                    currentI = i - (counterL - 3);
                                    return 3;
                                }
                            }
                        }

                    } else {
                        if (counterPdr == 4 || counterPdl == 4) {//for 4 consecutive player pieces, return 1 
                            return 1;
                        } else if (counterCdr == 4 || counterCdl == 4) {//for 4 consecutive computer pieces, return 2 
                            return 2;
                        }
                    }
                    counterR++;
                    counterL++;
                } else {
                    notAtEnd = false;
                }
            }
        }
        return 0;
    }

}
