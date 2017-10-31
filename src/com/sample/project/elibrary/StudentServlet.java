package com.sample.project.elibrary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.beans.StudentBean;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = -8395278903186338136L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		StudentBean bean=new StudentBean();
		bean.setFirstname(request.getParameter(""));
		bean.setLastname(request.getParameter(""));
		bean.setEmail(request.getParameter(""));
		bean.setPassword(request.getParameter(""));
		bean.setNumber(request.getParameter(""));
	}

}
