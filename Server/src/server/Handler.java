/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Esraa
 */
public class Handler extends Thread {

    static DataInputStream dataInputStream;
    static PrintStream printStream;
    static Vector<Handler> clientsVector = new Vector<Handler>();
    int x = 0;

    public Handler(Socket s) //Constructor
    {
        try {
             dataInputStream = new DataInputStream(s.getInputStream());
             printStream = new PrintStream(s.getOutputStream());
            Handler.clientsVector.add(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (true) {
            try {
                String msg = dataInputStream.readLine();
                
                String[] output = new String[3];

                String[] str = msg.split(" ! ");
                Player player = new Player();
                if (str.length == 1)
                {
                    sendMessageToSender(msg);
                } 
                else {
                    if (str.length == 3) {
                        player.setEmail(str[0]);
                        player.setUserName(str[1]);
                        player.setPassword(str[2]);
                        try {
                                Handler.printStream.println(DAO.SignUp(player));
                            } catch (SQLException ex) {
                                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                }
            } catch (IOException ex) {
                try {
                    dataInputStream.close();
                    printStream.close();
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex1) {
                    Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }

    void sendMessageToSender(String msg) {
        Handler ch = clientsVector.get(x);

        System.out.println("X = " + x);
        if (msg.charAt(0) == ':') {
            try {
                // retrive data
                Player player = new Player();
                player = DAO.retriveInformation(msg.substring(1));
                String information = player.getUserName() + ":" + player.getTootalScoore();
                ch.printStream.println(information);
                System.err.println("information = " + information);
            } catch (SQLException ex) {
                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //log in
            int index = msg.indexOf(":");
            String email = msg.substring(0, index);
            String password = msg.substring(index + 1);

            try {
                boolean resualt = DAO.checkLogin(email, password);
                ch.printStream.println(resualt);
                System.err.println("resualt = " + resualt);
            } catch (SQLException ex) {
                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        System.out.println("clientsVector = " + clientsVector);

    }

}
