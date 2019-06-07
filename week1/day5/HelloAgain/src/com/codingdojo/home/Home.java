package com.codingdojo.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//		String[] people = { "George", "Sally", "Holly" };
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		if (session.getAttribute("names") == null) {
			session.setAttribute("names", new ArrayList<String>());
		}
		
		ArrayList<String> names = (ArrayList<String>) session.getAttribute("names");
		
		System.out.println(names);
		
		System.out.println(name);
		
		response.setContentType("text/html");
		request.setAttribute("name", name);
		request.setAttribute("people", names);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/hello.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		
		ArrayList<String> names = (ArrayList<String>) session.getAttribute("names");
		names.add(name);
		
		session.setAttribute("name", name);
		
		response.sendRedirect("/HelloAgain/Home");
	}

}
