package com.pwskills.danish.controller;

import java.io.IOException;

import com.pwskills.danish.dateobjects.StudentDto;
import com.pwskills.danish.factory.StudentServiceFactory;
import com.pwskills.danish.service.IStudentService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doProcess(request, response); //we don't know data will come by get or post
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response); //we don't know data will come by get or post
	
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		IStudentService service = StudentServiceFactory.getStudentService();
		
		if(request.getRequestURI().endsWith("addform")) {
			
			String sname= request.getParameter("sname");
			String sage= request.getParameter("sage");
			String saddress= request.getParameter("saddr");
			
			StudentDto stdDto = new StudentDto();
			stdDto.setSname(sname);
			stdDto.setSage(Integer.parseInt(sage));
			stdDto.setSaddress(saddress);
			
			String status = service.insertRecord(stdDto);   //
			
			RequestDispatcher rd = null;
			
			if(status.equalsIgnoreCase("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../insert.jsp");
				rd.forward(request, response);
			} else{
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../insert.jsp");
				rd.forward(request, response);
			}
		}
		
		if(request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			
			StudentDto stdDto = service.readRecord(Integer.parseInt(sid));  //
			request.setAttribute("student", stdDto);
			
			RequestDispatcher rd = null;
			rd= request.getRequestDispatcher("../search.jsp");
			rd.forward(request, response);
			
		}
		
		if(request.getRequestURI().endsWith("deleteform")) {
					String sid = request.getParameter("sid");
					String status = service.deleteRecord(Integer.parseInt(sid));  //
					
					RequestDispatcher rd = null;
					if(status== "success") {
						request.setAttribute("status", "success");
						rd = request.getRequestDispatcher("../delete.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("status", "failure");
						rd = request.getRequestDispatcher("../delete.jsp");
						rd.forward(request, response);
					}
		}
		
		if(request.getRequestURI().endsWith("editform")) {
			String sid = request.getParameter("sid");
			
			StudentDto stdDto = service.readRecord(Integer.parseInt(sid));  
			request.setAttribute("student", stdDto);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
			rd.forward(request, response);
			
			
		}
		
		if(request.getRequestURI().endsWith("updateform")) {
			String sid = request.getParameter("sid");
			String sname= request.getParameter("sname");
			String sage= request.getParameter("sage");
			String saddress= request.getParameter("saddress");
			
			StudentDto stdDto = new StudentDto();
			stdDto.setSid(Integer.parseInt(sid));
			stdDto.setSname(sname);
			stdDto.setSage(Integer.parseInt(sage));
			stdDto.setSaddress(saddress);
			
			String status = service.updateRecord(stdDto);
			 
			request.setAttribute("status", status);
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		}
	}
}
