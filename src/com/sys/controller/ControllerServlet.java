package com.sys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sys.dao.ProjectDAO;
import com.sys.model.Project;


/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String domain=request.getParameter("domain");
		Project p=new Project(id,title,description,domain);
		try {
		ProjectDAO pdao=new ProjectDAO();
		
		boolean b=pdao.insertProject(p);
		if(b==true)
		request.getRequestDispatcher("success.jsp").include(request,response);
		}
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		}
	}
}
