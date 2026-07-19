package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.demo.dao.UserDAO;
import com.demo.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		 // Session Check
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {

            response.sendRedirect("login.jsp");
            return;

        }

        String username = request.getParameter("username");

        UserDAO dao = new UserDAO();

        ArrayList<User> list = dao.searchUser(username);
        
        System.out.println("Search Size = " + list.size());

        request.setAttribute("users", list);

        request.getRequestDispatcher("users.jsp")
               .forward(request, response);

	}
	

}
