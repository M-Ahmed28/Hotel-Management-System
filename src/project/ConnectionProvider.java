/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides database connection instances.
 * @author Sudhir Kushwaha
 */
public class ConnectionProvider {
    
    public static Connection getCon() {
        // Refactoring: Extract Variables for Primitive Obsession
        String dbUrl ="jdbc:mysql://localhost:3306/hotel_management?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "p@ssw0rd";
        String driverClass = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException | ClassNotFoundException ex) {
            // Refactoring: Removed Dead Code (Empty Catch)
            // Properly logging or printing stack trace to preserve behavior visibility
            ex.printStackTrace();
            return null;
        }
    }
}
