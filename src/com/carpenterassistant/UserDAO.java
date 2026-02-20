/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carpenterassistant;

import java.sql.*;

/**
 *
 * @author bradi
 */
public class UserDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/carpenter_app";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "devry123";

    public static User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password); // Note: plain-text for now

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // login failed
    }

    public static boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password); // Match plain-text for now

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // returns true if a match was found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static boolean registerUser(String username, String email, String password) {
        System.out.println("Trying to register: " + username + ", " + email + ", " + password);
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password); // Plain text for now — consider hashing!

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // This is what you add 👇
            System.err.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
}
