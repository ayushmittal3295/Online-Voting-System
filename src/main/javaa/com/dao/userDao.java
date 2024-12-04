package com.voting.dao;

import com.voting.model.User; // Ensure the model class is named User
import com.voting.db.DBConnection; // Adjust the package name for DB connection

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    // Add a new user to the database
    public boolean addUser (User user) {
        String query = "INSERT INTO users (username, password, email, is_verified) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setBoolean(4, user.isVerified()); // Assuming you have a verification status
            return stmt.executeUpdate() > 0; // Return true if insert is successful
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle exception properly
        }
        return false; // Return false if there was an issue
    }

    // Get a user by their username
    public User getUser ByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("user_id"), // Ensure this matches the column name in DB
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getBoolean("is_verified") // Assuming you have a verification status
                );
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle exception properly
        }
        return null; // Return null if no user is found
    }

    // Verify a user's credentials
    public boolean verifyUser (String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Return true if a matching user is found
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle exception properly
        }
        return false; // Return false if there was an issue
    }

    // Additional methods can be added here, such as updating user info, deleting users, etc.
}