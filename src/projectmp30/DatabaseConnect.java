/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmp30;
import java.sql.*;



/**
 *
 * @author karth
 */
public class DatabaseConnect {
    private static String url = "jdbc:mysql://localhost:3306/projectmp3";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "password";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println(ex); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println(ex); 
        }
        return con;
    }
}

    