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
    // all users in connection
    static Vector<Handler> clientsVector = new Vector<Handler>();
    //online Players vector
    static Vector<Handler> onlinePlayers = new Vector<Handler>();
    //UserName vector
    static Vector<String> avaliablePlayers = new Vector<String>();
    static int playerCount = 0;
    static String totalPlayers;
    int x = 0;
    boolean flag = true;
    boolean isRemoved = true;
    int removed;
    static Handler player1;

    public Handler(Socket s) //Constructor
    {
        try {
            dataInputStream = new DataInputStream(s.getInputStream());
            printStream = new PrintStream(s.getOutputStream());
            Handler.clientsVector.add(this);
            x = clientsVector.size() - 1;

            start();

        } catch (IOException ex) {
            new Alert(Alert.AlertType.ERROR, "Error in open connection in server\n"
                    + ex.getMessage()).show();
        }
    }

    public void run() {
        System.out.println("in start");
        while (true) {
            try{
                String message = dataInputStream.readLine();
                JSONObject jSObject = new JSONObject(message);
                System.out.println("message: "+jSObject);
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

                    case "request key":
                        //String message2 = dataInputStream.readLine();
                        //JSONObject jSObj = new JSONObject(message2);
                        String player2ID = jSObject.getString("player2 key");
                        String player1ID = jSObject.getString("player1 key");
                        Handler player1Thread = onlinePlayers.get(Integer.parseInt(player1ID));
                        Handler player2Thread = onlinePlayers.get(Integer.parseInt(player2ID));
                        System.out.println("player2 id: "+player2ID+" thread no: "+onlinePlayers.get(Integer.parseInt(player2ID)));
                        System.out.println("player1 id: "+player1ID+" thread no: "+onlinePlayers.get(Integer.parseInt(player1ID)));
                        sendRequestMessage(player1ID,player2ID, player2Thread, player1ID);
                        break;
                        
                    case "replay":
                        System.out.println("request replay :" + jSObject.getString("request replay"));
                        String IDPlayer1 = jSObject.getString("player1 NO");
                        String IDPlayer2 = jSObject.getString("player2 NO");
                        sendReplayToplayer2(jSObject.getString("request replay"), onlinePlayers.get(Integer.parseInt(IDPlayer1)), onlinePlayers.get(Integer.parseInt(IDPlayer2)));
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

    void sendMessageToSender(String msg) {
        System.out.println("X from sendMessageToSender = " + x);
        Handler handler = clientsVector.get(x);
        System.out.println("handler from sendMessageToSender >>>>>>>>>> " + handler);

        System.out.println("Message >>>>>>>> " + msg);
        handler.printStream.println(msg);
        System.out.println("clientsVector = " + clientsVector);
    }
    void ShowAvaliablePlayers()
    {
        for( Handler ch: clientsVector)
            {
                System.out.println("ch" + ch);
                JSONObject playerList = new JSONObject();
                playerList.put("key", "player list");
                playerList.put("list", avaliablePlayers);
                ch.printStream.println(playerList);
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
            jsono.put("username", DAO.retriveInformation(email).getUserName());
            jsono.put("score", DAO.retriveInformation(email).getTootalScoore());
            String reply = jsono.toString();
            sendMessageToSender(reply);
            if (resualt)
            {
                System.out.println("you are in condition");
                Player player;
                player = DAO.retriveInformation(email);
                avaliablePlayers.add(playerCount, player.getUserName());
                onlinePlayers.add(playerCount, clientsVector.get(x));
                playerCount++;
                ShowAvaliablePlayers();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void sendRequestMessage(String one, String two, Handler threadPlayer2,String player1Key)
    {
        JSONObject requestMessage = new JSONObject();
        requestMessage.put("key", "play with me, please");
        requestMessage.put("player1 username", avaliablePlayers.get(Integer.parseInt(player1Key)));
        requestMessage.put("player1 NO", one);
        requestMessage.put("player2 NO", two);
        System.out.println("request JSON :"+requestMessage);
        threadPlayer2.printStream.println(requestMessage);
    }
    
    void sendReplayToplayer2(String reply, Handler playerOne, Handler playertwo)
    {
        JSONObject requestResponse = new JSONObject();
        requestResponse.put("key", "Request Response");
        requestResponse.put("response", reply);
        System.out.println("request response :"+requestResponse);
        playerOne.printStream.println(requestResponse);
    }
}
