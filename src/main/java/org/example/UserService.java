package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    // A simple map to simulate a database
    private Map<String, User> userDatabase = new HashMap<>();

    public boolean registerUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or blank.");
        }

        if (userDatabase.containsKey(user.getUsername())) {
            return false; // User already exists
        }

        userDatabase.put(user.getUsername(), user);
        return true; // User registered successfully
    }

    public User loginUser(String username, String password) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or blank.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank.");
        }
        User user = userDatabase.get(username);

        if (user == null) {
            return null; // User not found
        }

        if (!user.getPassword().equals(password)) {
            return null; // Wrong password
        }

        return user; // Login successful
    }

    public boolean updateUserProfile(User user, String newUsername, String newPassword, String newEmail) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (newUsername == null || newUsername.isBlank()) {
            throw new IllegalArgumentException("New username cannot be null or blank.");
        }
        if (newPassword == null || newPassword.isBlank()) {
            throw new IllegalArgumentException("New password cannot be null or blank.");
        }
        if (newEmail == null || newEmail.isBlank()) {
            throw new IllegalArgumentException("New email cannot be null or blank.");
        }

        // logic to update user profile
        if (userDatabase.containsKey(newUsername)) {
            return false; // New username is already taken
        }

        user.setUsername(newUsername);
        user.setPassword(newPassword);
        user.setEmail(newEmail);

        userDatabase.put(newUsername, user);
        return true; // User profile updated successfully
    }

}
