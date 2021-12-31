package tic_tac_toe_game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

public class DAO {

    static Connection con;

    public DAO() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database_tic_tack", "database", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void connection() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database_tic_tack", "database", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // this methoed to check email and password are correct or not
    static boolean checkLogin(String email, String password) {
        String realPassword = " ";
        boolean resault = false;
        try {
            PreparedStatement pst = con.prepareStatement("select password from Player where email = ?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                realPassword = rs.getString(1);
            }

            if (realPassword.equals(password)) {
                resault = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resault;
    }

    //this methoed to retreive name and score from database
    static Player retriveInformation(String email) {
        Player player = new Player();
        try {
            PreparedStatement ps = con.prepareStatement("select username, totalscoore from Player where email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                player.setUserName(rs.getString(1));
                player.SetTotalScoore(Integer.parseInt(rs.getString(2)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player;
    }

}
