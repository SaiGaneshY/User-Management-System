package com.demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.dao.UserDAO;
import com.demo.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDAO dao = new UserDAO();
		boolean status = dao.loginUser(username, password);

		if (status) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect("welcome.jsp");

		} else {
			response.sendRedirect("login.jsp?error=1");
			
		}

	}

}
