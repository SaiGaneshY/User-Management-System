package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.demo.model.User;
import com.demo.util.DBConnection;

public class UserDAO {

	// Register User
	public boolean registerUser(User user) {

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("INSERT INTO users(username, password) VALUES(?, ?)");

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			int rows = ps.executeUpdate();

			ps.close();
			con.close();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// Login User
	public boolean loginUser(String username, String password) {

		boolean status = false;

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				status = true;
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// Get all users
	public ArrayList<User> getAllUsers() {

		ArrayList<User> list = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM users");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				User user = new User();

				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				list.add(user);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// Get one user by ID
	public User getUserById(int id) {

		User user = null;

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id=?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new User();

				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	// Update user
	public boolean updateUser(User user) {

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("UPDATE users SET username=?, password=? WHERE id=?");

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getId());

			int rows = ps.executeUpdate();

			ps.close();
			con.close();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// Delete user
	public boolean deleteUser(int id) {

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id=?");

			ps.setInt(1, id);

			int rows = ps.executeUpdate();

			ps.close();
			con.close();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
	
	//search user
	
	public ArrayList<User> searchUser(String username) {

	    ArrayList<User> list = new ArrayList<>();

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	                "select * from users where username like ?");

	        ps.setString(1, "%" + username + "%");

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            User user = new User();

	            user.setId(rs.getInt("id"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));

	            list.add(user);

	        }

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return list;

	}
	
	
}
