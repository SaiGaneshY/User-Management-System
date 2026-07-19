package com.demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.dao.UserDAO;
import com.demo.model.User;
import com.demo.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));

			UserDAO dao = new UserDAO();

			User user = dao.getUserById(id);

			if (user != null) {

				request.setAttribute("user", user);

				request.getRequestDispatcher("edit.jsp").forward(request, response);

			} else {
				response.getWriter().println("User not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
