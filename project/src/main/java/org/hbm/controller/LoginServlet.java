package org.hbm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hbm.dao.UserOperation;
import org.hbm.dto.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long phone = Long.parseLong(req.getParameter("ph"));
		String password = req.getParameter("ps");
		UserOperation uo=new UserOperation();
		User user = uo.verifyUser(phone, password);
		RequestDispatcher dispatcher = null;
		PrintWriter writer = resp.getWriter();
		if(user!=null) {
			HttpSession s = req.getSession();
			s.setAttribute("User", user);
			dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
		}else {
		writer.write("<html><body><h2>invalid input</h2></body></html>");
		dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
		}
	}
}