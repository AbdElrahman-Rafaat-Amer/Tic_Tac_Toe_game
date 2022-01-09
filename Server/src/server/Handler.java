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

    DataInputStream dataInputStream;
    PrintStream printStream;
    static Vector<Handler> clientsVector = new Vector<Handler>();
    int x = 0;
    boolean flag = true;
    boolean isRemoved = true;
    int removed;

    public Handler(Socket s) //Constructor
    {
        try {
            dataInputStream = new DataInputStream(s.getInputStream());
            printStream = new PrintStream(s.getOutputStream());
            Handler.clientsVector.add(this);
            x = clientsVector.size() - 1;
            start();
            /* System.out.println("before start");
                new Thread() {
                    public void run() {
                        System.out.println("in start");
                        while (true) {
                            try {
                                String message = dataInputStream.readLine();
                                sendMessageToSender(message);
                            } catch (IOException ex) {
                                try {
                                    System.out.println("remove");
                                    dataInputStream.close();
                                    printStream.close();
                                    clientsVector.remove(this);
                                    // x--;
                                    isRemoved = !isRemoved;
                                    break;
                                } catch (IOException ex1) {
                                    //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
                                    new Alert(Alert.AlertType.ERROR, "Error in read dataInputStream in run method server\n"
                                            + ex1.getMessage()).show();
                                }

                            }
                        }
                    }
                }.start();*/
        } catch (IOException ex) {
            new Alert(Alert.AlertType.ERROR, "Error in open connection in server\n"
                    + ex.getMessage()).show();
            //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        System.out.println("in start");
        while (true) {
            try {
                String message = dataInputStream.readLine();
                String[] output = new String[3];
                String[] str = message.split(" ! ");
                Player player = new Player();
                System.out.println("str length >>>>>>>>>>>> " + str.length);
                if (str.length == 1) {
                    System.out.println("will go to sendMessageToSender to login");
                    sendMessageToSender(message);
                } else {
                    if (str.length == 3) {
                        System.out.println("will go to signup to signup");
                        player.setEmail(str[0]);
                        player.setUserName(str[1]);
                        player.setPassword(str[2]);
                        try {
                            Handler handler = clientsVector.get(x);
                            //DAO.SignUp(player);
                            handler.printStream.println(DAO.SignUp(player));
                        } catch (SQLException ex) {
                            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            } catch (IOException ex) {
                try {
                    System.out.println("remove");
                    dataInputStream.close();
                    printStream.close();
                    clientsVector.remove(this);
                    // x--;
                    isRemoved = !isRemoved;
                    break;
                } catch (IOException ex1) {
                    //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
                    new Alert(Alert.AlertType.ERROR, "Error in read dataInputStream in run method server\n"
                            + ex1.getMessage()).show();
                }

            }
        }
    }

    /*void sendToAll() {
        for (Handler h : clientsVector) {
            new Thread(h.getName());
        }
    }*/
    void sendMessageToSender(String msg) {
        System.out.println("X from sendMessageToSender = " + x);
        Handler handler = clientsVector.get(x);
        System.out.println("handler from sendMessageToSender >>>>>>>>>> " + handler);

        System.out.println("Message >>>>>>>> " + msg);

        int index = msg.indexOf(':');
        System.out.println("index >>>>>>>>>>>>> " + index);
        String email = msg.substring(0, index);
        String password = msg.substring(index + 1);

        System.out.println("eamil >>> " + email + "\t\t\tPassword >>> " + password);

        try {
            boolean resualt = DAO.checkLogin(email, password);
            System.out.println("Resualt >>>>>>>>>>>> " + resualt);
            if (resualt == true) {
                //Log in Success
                Player player = DAO.retriveInformation(email);  // retrive information of player
                System.out.println("information >>>>>>>>> " + player.getUserName() + "\t\t" + player.getTootalScoore());
                
                handler.printStream.println("true" + " " + player.getUserName() + " " + player.getTootalScoore());
            } else {
                //Log in Failed
                handler.printStream.println("false");
            }
        } catch (SQLException ex) {
            System.out.println("Error in sendMessageToSender in server\n" + ex.getMessage());
        }
        System.out.println("clientsVector = " + clientsVector);
    }

    
}
