package org.hbm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hbm.dao.ProductOperation;
import org.hbm.dto.Product;
import org.hbm.dto.User;

@WebServlet("/viewProducts")
public class ViewProdServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User u =(User)req.getSession().getAttribute("User");
	ProductOperation po = new ProductOperation();
	List<Product> products = po.findProductByUserId(u.getId());
	req.setAttribute("products", products);
	RequestDispatcher dispatcher = req.getRequestDispatcher("viewProduct.jsp");
	dispatcher.forward(req, resp);
}
}
