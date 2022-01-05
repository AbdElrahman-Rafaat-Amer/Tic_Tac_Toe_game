/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tac_toe_game;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static tic_tac_toe_game.GameScene.winner;

/**
 *
 * @author Abdo
 */
public class Game {
    
    static class NextMove {
        
        public int row, col;
    }
    
    public static Boolean isMovesLeft(Label[][] labels) {
        boolean resualt = false;
        for (Label[] row : labels) {
            for (Label cell : row) {
                if (cell.getText().isEmpty() || cell.getText().equals("")) {
                    resualt = true;
                }
            }
        }
        return resualt;
        
    }
    
    protected static boolean checkWinner(Label[][] labels) {
        boolean isDraw = true;
        for (int row = 0; row < 3; row++) {
            if (labels[row][0].getText().equals(labels[row][1].getText()) && labels[row][1].getText().equals(labels[row][2].getText())) {
                switch (labels[row][0].getText()) {
                    case "X":
                        isDraw = false;
                        winner = "COMPUTER WIN";
                        //goToWinnerPage(stage);
                        break;
                    case "O":
                        isDraw = false;
                        winner = "YOU WIN";
                        // goToWinnerPage(stage);
                        break;
                }
            }
        }
        
        for (int col = 0; col < 3; col++) {
            if (labels[0][col].getText().equals(labels[1][col].getText()) && labels[1][col].getText().equals(labels[2][col].getText())) {
                switch (labels[0][col].getText()) {
                    case "X":
                        isDraw = false;
                        winner = "COMPUTER WIN";
                        //goToWinnerPage(stage);
                        break;
                    case "O":
                        isDraw = false;
                        winner = "YOU WIN";
                        // goToWinnerPage(stage);
                        break;
                }
            }
        }
        
        if (labels[0][0].getText().equals(labels[1][1].getText()) && labels[1][1].getText().equals(labels[2][2].getText())) {
            switch (labels[0][0].getText()) {
                case "X":
                    isDraw = false;
                    winner = "COMPUTER WIN";
                    //goToWinnerPage(stage);
                    break;
                case "O":
                    isDraw = false;
                    winner = "YOU WIN";
                    // goToWinnerPage(stage);
                    break;
            }
        }
        
        if (labels[0][2].getText().equals(labels[1][1].getText()) && labels[1][1].getText().equals(labels[2][0].getText())) {
            switch (labels[0][2].getText()) {
                case "X":
                    isDraw = false;
                    winner = "COMPUTER WIN";
                    // goToWinnerPage(stage);
                    break;
                case "O":
                    isDraw = false;
                    winner = "YOU WIN";
                    //goToWinnerPage(stage);
                    break;
            }
        }
        return isDraw;
    }
    
    static void goToWinnerPage(Stage stage) {
        Parent root2;
        try {
            // winner = null;
            // values = null;
            root2 = new ResultScene(stage);
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();
        } catch (MalformedURLException ex) {
            Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
