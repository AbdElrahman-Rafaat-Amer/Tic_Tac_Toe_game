/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tac_toe_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hager
 */
public class Records {

    public static String firstPlayer = "Player1";
    public static String secondPlayer = "Player2";
    public static String dirc = "recordes";

    public static void save(String saved) {
        String fileName = preperDirctory();
        FileWriter writer = null;
        try {
            writer = new FileWriter(dirc + "\\" + fileName);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(saved);
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(GameTwoPlayersOffline.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(GameTwoPlayersOffline.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static String preperDirctory() {
        File file = new File(dirc);
        System.out.println(file.exists());
        if (!file.exists()) {
            file.mkdirs();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" yyyy MM dd HH mm ss");
        LocalDateTime now = LocalDateTime.now();
        String text = firstPlayer + " Vs " + secondPlayer + " " + dtf.format(now);

        return text;
    }

    public static String open(File file) {
        String text = null;
        try {
            FileReader fileReadere = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReadere);
            try {
                text = buffer.readLine();
                System.out.println("text readed from file " + text);
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                buffer.close();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;

    }

}
