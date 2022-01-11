/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tac_toe_game;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tic_tac_toe_game.Game;

/**
 *
 * @author hager
 */

public class RetriveRecords {
     public static String open() {
        String text = null;
        try {
            FileReader file= new FileReader("abdo") ;
            
            BufferedReader buffer = new BufferedReader(file);
            try {
                text = buffer.readLine();
                System.out.println("text is here" +text);                  
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
           // buffer.read(saved);
            try {
                buffer.close();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text ;
        
    }
    
}


    
    

