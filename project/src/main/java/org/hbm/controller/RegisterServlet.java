package org.hbm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hbm.dao.UserOperation;
import org.hbm.dto.User;
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long phone = Long.parseLong(req.getParameter("ph"));
		String password = req.getParameter("ps");
		String email = req.getParameter("em");
		String gender = req.getParameter("gendeer");
		String name = req.getParameter("nm");
		int age = Integer.parseInt(req.getParameter("age"));
		User u = new User();
		
		u.setAge(age);
		u.setGender(gender);
		u.setName(name);
		u.setPassword(password);
		u.setPhone(phone);
		u.setEmail(email);
		
		UserOperation uo = new UserOperation();
		u=uo.saveUser(u);
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body><h2>Registered</h2></body></html>");
	}
}