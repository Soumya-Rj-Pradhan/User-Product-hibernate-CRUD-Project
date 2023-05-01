package org.hbm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hbm.dao.UserOperation;
import org.hbm.dto.User;

@WebServlet("/delet")
public class DeletUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("User");
		if(u!=null) {
			int id = u.getId();
			UserOperation uo = new UserOperation();
			uo.deletUser(id);
			session.invalidate();
			req.setAttribute("msz", "ACCOUNT  IS DELETED...");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}else
			resp.sendRedirect("login.jsp");
	}
}