package tic_tac_toe_game;


import java.util.Random;
import javafx.scene.control.Label;

/**
 *
 * @author Abdo
 */
public class EasyLevel {

    static Game.NextMove moveNext(Label[][] labels) {
        //computer turn
        Game.NextMove nextMove = new Game.NextMove();
        Random random = new Random();
        int randomRow = random.nextInt(3);
        int randomCol = random.nextInt(3);
        while (!labels[randomRow][randomCol].getText().equals("")) {
            randomRow = random.nextInt(3);
            randomCol = random.nextInt(3);
        }

        nextMove.row = randomRow;
        nextMove.col = randomCol;

        return nextMove;
    }
    

}
