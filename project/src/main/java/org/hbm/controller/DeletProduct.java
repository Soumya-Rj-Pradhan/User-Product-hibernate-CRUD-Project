package org.hbm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hbm.dao.ProductOperation;
import org.hbm.dto.User;

@WebServlet("/deletProduct")
public class DeletProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User)req.getSession().getAttribute("User");
		if(u!=null) {
			int id = Integer.parseInt(req.getParameter("pid"));
			ProductOperation po = new ProductOperation();
			po.deleteProduct(id);
			RequestDispatcher d = req.getRequestDispatcher("viewProducts");
			d.forward(req, resp);
		}else
			resp.sendRedirect("login.jsp");
	}
}
