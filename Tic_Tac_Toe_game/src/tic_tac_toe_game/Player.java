/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsingselection;

/**
 *
 * @author ayaab
 */
public class Player {
 
    private int id ;
     private String username;
     private String email;
     private String password;
     private int totalScoore;
 
   
   public Player (){};
   
   public Player (int id , String userName, String email ,String password , int TotalScoore )
   {
        this.id = id;
        this.username = userName;
        this.email = email;
        this.password = password ;
        this.totalScoore = TotalScoore;
   }
   
    //setter and getter 
    int getId() 
    {return id;}
    
     String getUserName()
     {return username;}
    
    String getEmail()
    {return email;}
    
    String getPassword()
    {return password;}
    
    int getTootalScoore() 
    {return totalScoore;}
    
    void  setId( int id ) 
    {this.id= id;}
    
     void setUserName( String username)
     {this.username= username;}
    
    void  setEmail( String email)
    {this.email= email;}
    
    void setPassword( String password)
    {this.password=password;}
    
    void  SetTotalScoore( int TotalScoore ) 
    {this.totalScoore= totalScoore;}
}
