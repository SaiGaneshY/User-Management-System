package com.demo.test;

import java.sql.Connection;

import com.demo.util.DBConnection;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = DBConnection.getConnection();

		if (con != null) {
			System.err.println("Connection Successful");
		} else {
			System.out.println("Connection Failed");
		}

	}

}
