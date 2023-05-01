package org.hbm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hbm.dao.ProductOperation;
import org.hbm.dto.Product;
import org.hbm.dto.User;

@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("nm");
		String brand = req.getParameter("br");
		String description = req.getParameter("desc");
		String category = req.getParameter("cat");
		String image = req.getParameter("im");
		Double price = Double.parseDouble(req.getParameter("price"));
		Product p = new Product();
		p.setId(id);
		p.setBrand(brand);
		p.setCategory(category);
		p.setCost(price);
		p.setDescription(description);
		p.setImage(image);
		p.setName(name);
		ProductOperation po = new ProductOperation();
		User u = (User) req.getSession().getAttribute("User");
		p = po.updateProduct(p, u.getId());
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body><h2></h2>PRODUCT ADDED with id = " + p.getId() + "</body></html>");
	}
}