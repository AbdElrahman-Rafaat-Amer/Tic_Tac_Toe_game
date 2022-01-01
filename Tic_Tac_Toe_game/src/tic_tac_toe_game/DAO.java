package tic_tac_toe_game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    static void startConnection() {
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
    
    
    // to insert player un player table .. return 1 if insertion done and 0 if insertion undone
        static int SignUp(Player dto)
        {
            //Compare email with existing emails to make sure it's not duplicated
            Statement statement;
            int flag=1;
            Player selectedData = new Player();
            try {
                statement = con.createStatement();
                 String QueryString = new String("select email from Player"); 
                        ResultSet resultSet = statement.executeQuery(QueryString);
                        while(resultSet.next())
                        { 
                            if(resultSet.getString(1).compareTo(dto.getEmail())==0)
                            {
                                flag = 0;
                                System.err.println("sorry, this email already exists");
                            }
                        }
                        statement.close();
                        PreparedStatement ps = con.prepareStatement("insert into Player values (?,?,?,?,?)");
                        ps.setInt(1,dto.getId());
                        ps.setString(2, dto.getUserName());
                        ps.setString(3,dto.getEmail());
                        ps.setString(4, dto.getPassword());
                        ps.setInt(5,dto.getTootalScoore());
                        ps.executeUpdate();
                        ps.close();
                } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex); 
            }
            return flag;
        }

}
