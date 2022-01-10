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
import org.json.*;

/**
 *
 * @author Esraa
 */
public class Handler extends Thread {

    DataInputStream dataInputStream;
    PrintStream printStream;
    static Vector<Handler> clientsVector = new Vector<Handler>();
    //static Vector<String> avaliablePlayers = new Vector<>();
    static JSONObject avaliablePlayers  = new JSONObject();
    static int playerCount = 0;
    static String totalPlayers;
    int x = 0, i=0;
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
            try{
                String message = dataInputStream.readLine();
                JSONObject jSObject = new JSONObject(message);
                String key = jSObject.getString("key");
                System.out.println("key  >>>>>>>>>>>>>>>>>>>>> " + key);//jSObject.get("key");
                switch (key) {
                    case "login":
                        login(jSObject);
                        break;
                    case "signup":
                        //code will insert in database
                        Player player = new Player();
                        player.setEmail(jSObject.getString("Email"));
                        player.setId(jSObject.getInt("ID"));
                        player.setUserName(jSObject.getString("Username"));
                        player.setPassword(jSObject.getString("Password"));
                        player.SetTotalScoore(jSObject.getInt("Score"));
                        boolean resualt = DAO.SignUp(player);
                        JSONObject jsono = new JSONObject();
                        jsono.put("signup", resualt);
                        printStream.println(jsono);
                        break;

                    case "playerList":
                        //code will insert in database
                        break;

                    case "retriveInformation":
                        //code will insert in database
                        break;
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

            } catch (SQLException ex) {
                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
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
        handler.printStream.println(msg);
        //int index = msg.indexOf(':');
        //System.out.println("index >>>>>>>>>>>>> " + index);
        //String email = msg.substring(0, index);
        //String password = msg.substring(index + 1);
        //System.out.println("eamil >>> " + email + "\t\t\tPassword >>> " + password);
/*
                Player player = DAO.retriveInformation(email);  // retrive information of player
                //request page
                clientsVector.get(clientsVector.size()-1).setName(DAO.RetrieveUsername(email));
                totalPlayers = totalPlayers+" "+ch.getName();
                avaliablePlayers.add(i,ch.getName());
                i++;
                ShowAvaliablePlayers();
                System.out.println("information >>>>>>>>> " + player.getUserName() + "\t\t" + player.getTootalScoore());
                
                handler.printStream.println("true" + " " + player.getUserName() + " " + player.getTootalScoore()+ " " +  totalPlayers);
                
               
                /*  Player player = DAO.retriveInformation(email);  // retrive information of player
                System.out.println("information >>>>>>>>> " + player.getUserName() + "\t\t" + player.getTootalScoore());
                
                handler.printStream.println("true" + " " + player.getUserName() + " " + player.getTootalScoore());
                handler.printStream.println("true");
            } else {
                //Log in Failed
                handler.printStream.println("false");
            }
        } catch (SQLException ex) {
            System.out.println("Error in sendMessageToSender in server\n" + ex.getMessage());
        }*/
        System.out.println("clientsVector = " + clientsVector);
    }
    void ShowAvaliablePlayers()
    {
        for( Handler ch: clientsVector)
            {
                System.out.println("ch" + ch);
                ch.printStream.println(avaliablePlayers);
            }    
    }

    private void login(JSONObject object) {

        String email = object.getString("email");
        String password = object.getString("password");
        System.out.println("Email = " + email + "\t\t\tPassword = " + password);

        try {
            boolean resualt = DAO.checkLogin(email, password);
            
            JSONObject jsono = new JSONObject();
            jsono.put("login", resualt);
            String reply = jsono.toString();
            sendMessageToSender(reply);
            if (resualt)
            {
                System.out.println("you are in condition");
                Player player;
                player = DAO.retriveInformation(email);
                avaliablePlayers.put(String.valueOf(playerCount), player.getUserName());
                playerCount++;
                System.out.println(avaliablePlayers);
                ShowAvaliablePlayers();
            }
            //   int j = 0;
            //  jsono.put(String.valueOf(j), DAO.retriveInformation(email).getUserName());
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
