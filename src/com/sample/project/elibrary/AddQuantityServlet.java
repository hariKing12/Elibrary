package com.sample.project.elibrary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddQuantityServlet")
public class AddQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String callno=request.getParameter("callno");
		int  number=Integer.parseInt(request.getParameter("number"));
		
		AddquantityDao dao=new AddquantityDao();
		int status=dao.quantity(number, callno);
		if(status>0){
			System.out.println("updated successfully");
		}else{
			System.out.println("Not updated");
		}
	}

}
