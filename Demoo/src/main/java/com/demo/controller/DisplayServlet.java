package com.demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.demo.dao.UserDAO;
import com.demo.model.User;
import com.demo.util.DBConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Check session
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		UserDAO dao = new UserDAO();

		ArrayList<User> list = dao.getAllUsers();

		request.setAttribute("users", list);

		String update = request.getParameter("update");
		request.setAttribute("update", update);

		String delete = request.getParameter("delete");
		request.setAttribute("delete", delete);

		request.getRequestDispatcher("users.jsp").forward(request, response);
	}

}
