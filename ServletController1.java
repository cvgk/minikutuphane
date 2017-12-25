package bilgeadam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bilgeadam.dao.LibrarianDAOImpl;


import bilgeadam.model.*;
/**
 * Servlet implementation class ServletController1
 */
@WebServlet("/ServletController1")
public class ServletController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
	       dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LibrarianDAOImpl dao = new LibrarianDAOImpl();
		boolean found = false;
		List<Librarian> list = dao.tumCalisanlariGetir();
		for(int i=0;i<list.size();i++) {
			Librarian librarian = list.get(i);
			if(librarian.getUsername().equals(username)&&librarian.getPassword().equals(password)) {
				request.setAttribute("librarian", librarian);
				found = true;
			}
		}
		request.setAttribute("found", found);
		if(found) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/yetki.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
