package com.demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.demo.dao.UserDAO;
import com.demo.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));

			UserDAO dao = new UserDAO();
			boolean status = dao.deleteUser(id);

			if (status) {
				response.sendRedirect("display?delete=success");

			} else {
				response.sendRedirect("display?delete=failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
