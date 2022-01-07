/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tac_toe_game;

import tic_tac_toe_game.Game.NextMove;
import javafx.scene.control.Label;

/**
 *
 * @author Abdo
 */
public class HardLevel {

    static int minimax(Label board[][], int depth, Boolean isMax) {
        int score = Game.checkWinner(board);
        if (score == 3) {
            return score;
        } else {
            if (score == -3) {
                return score;
            } else {
                if (Game.isMovesLeft(board) == false) {
                    return 0;
                } else {
                    if (isMax) {
                        int best = -1000;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (board[i][j].getText().equals("")) {
                                    board[i][j].setText("X");
                                    best = Math.max(best, minimax(board, depth + 1, !isMax));
                                    board[i][j].setText("");
                                }
                            }
                        }
                        return best;

                    } else {
                        int best = 1000;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (board[i][j].getText().equals("")) {
                                    board[i][j].setText("O");
                                    best = Math.min(best, minimax(board, depth + 1, !isMax));
                                    board[i][j].setText("");
                                }
                            }
                        }
                        return best;
                    }
                }
            }

        }

    }

    public static NextMove moveNext(Label board[][]) {
        int bestVal = -1000;
        NextMove bestMove = new NextMove();
        bestMove.row = -1;
        bestMove.col = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().equals("")) {
                    board[i][j].setText("X");
                    int moveVal = minimax(board, 0, false);
                    board[i][j].setText("");
                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;

                    }
                }
            }
        }
        return bestMove;
    }
}
