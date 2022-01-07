package tic_tac_toe_game;

import tic_tac_toe_game.Game.NextMove;
import javafx.scene.control.Label;

/**
 *
 * @author Abdo
 */
public class MediumLevel {

    static int minimax(Label board[][], int depth, Boolean isMax) {
        int score = Game.checkWinner(board);
        if (depth == 3) {
            return 0;
        } else {

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

    }

    static NextMove moveNext(Label board[][]) {
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
