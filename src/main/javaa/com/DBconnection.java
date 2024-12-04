package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/user_web_app"; // Database URL
    private static final String USER = "root"; // MySQL username
    private static final String PASSWORD = "Somya@2236"; // MySQL password

    private static Connection connection = null;

    // Get connection method
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) { // Check if the connection is closed
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Register JDBC driver
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); // Establish connection
            } catch (ClassNotFoundException e) {
                e.printStackTrace(); // Handle class not found exception
                throw new SQLException("JDBC Driver not found.", e); // Wrap in SQLException
            }
        }
        return connection;
    }

    // Close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace(); // Handle SQL exception during closing
            }
        }
    }

    // Method to register a new user
    public static boolean registerUser (String username, String password, String email, String role) {
        String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, role);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if user was registered successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }

    // Method to validate user login
    public static User validateUser (String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Create a User object from the result set
                User user = new User();
                user.setUser Id(rs.getInt("userId")); // Corrected method name
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setActive(rs.getBoolean("isActive"));
                return user; // Return the user object if found
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no user found
    }

    // Method to record a vote
    public static boolean recordVote(int userId, int electionId) {
        String sql = "INSERT INTO votes (userId, electionId) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, electionId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if vote was recorded successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }

    // Method to check if a user has already voted in a specific election
    public static boolean hasVoted(int userId, int electionId) {
        String sql = "SELECT * FROM votes WHERE userId = ? AND electionId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, electionId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Return true if a record exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was

        }
        
        }}
        