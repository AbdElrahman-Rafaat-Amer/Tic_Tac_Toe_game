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
public class Handler extends Thread{
    DataInputStream dataInputStream;
    PrintStream printStream;
    static Vector<Handler> clientsVector = new Vector<Handler>();
        
        public Handler(Socket s)        //Constructor
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
        public void run()
        {
            while(true)
            {
                try {
                    String msg = dataInputStream.readLine();
                    String[] output= new String[3];
                    
                    String[] str=msg.split(" ! ");
                    Player player = new Player();
                    if(str.length==2)
                    {
                        try {
                            if(!DAO.checkLogin(str[0],str[1]))
                            {new Alert(Alert.AlertType.ERROR, "Password or email is wrong").show();}
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        if(str.length==3)
                        {
                            player.setEmail(str[0]);
                            player.setUserName(str[1]);
                            player.setPassword(str[2]);
                            try {
                                if(DAO.SignUp(player)!=1)
                                {
                                    new Alert(Alert.AlertType.ERROR, "UnSuccusseful signup").show();
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex); }
                        }
                    }     
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
        }
        
}
