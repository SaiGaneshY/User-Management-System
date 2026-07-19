package com.demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.demo.dao.UserDAO;
import com.demo.model.User;
import com.demo.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		UserDAO dao = new UserDAO();

		boolean status = dao.registerUser(user);

		if (status) {

			response.sendRedirect("login.jsp?success=1");

		} else {

			response.getWriter().println("Registration Failed");
		}

	}

}
