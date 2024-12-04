package com.user.model;

import java.util.List;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String role; // e.g., "voter", "admin"
    private boolean isActive; // Indicates if the user is active
    private List<Integer> votedElectionIds; // List of election IDs the user has voted in

    // Default constructor (no-argument constructor)
    public User() {
    }

    // Constructor with all fields
    public User(int userId, String username, String password, String email, String role, boolean isActive) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
        this.votedElectionIds = new ArrayList<>(); // Initialize the list
    }

    // Constructor without userId (useful for new user creation)
    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.isActive = true; // Default to active
        this.votedElectionIds = new ArrayList<>(); // Initialize the list
    }

    // Getters and Setters
    public int getUser Id() {
        return userId;
    }

    public void setUser Id(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Integer> getVotedElectionIds() {
        return votedElectionIds;
    }

    public void setVotedElectionIds(List<Integer> votedElectionIds) {
        this.votedElectionIds = votedElectionIds;
    }

    // Method to add an election ID to the list of voted elections
    public void addVotedElectionId(int electionId) {
        if (!votedElectionIds.contains(electionId)) {
            votedElectionIds.add(electionId);
        }
    }

    // Optional: Override toString for better debugging
    @Override
    public String toString() {
        return "User {" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", isActive=" + isActive +
                ", votedElectionIds=" + votedElectionIds +
                '}';
    }
}