package com.pwskills.danish.main;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PaginationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("pageSize");
		
	}

}
