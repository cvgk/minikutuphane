package bilgeadam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bilgeadam.dao.BookDAO;
import bilgeadam.dao.BookDAOImpl;
import bilgeadam.model.Book;

/**
 * Servlet implementation class ServletController2
 */
@WebServlet("/ServletController2")
public class ServletController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ServletController2() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		BookDAO bd = new BookDAOImpl();
		List<Book> list = bd.tumKitaplariGetir();
		String kitapismi = request.getParameter("kitapismi");
		for(int i=0;i<list.size();i++)
		{
			if(kitapismi.equals(list.get(i).getTitle()))
			{
				if(list.get(i).getAdet()>0)
				{
					out.println("bu kitabi alabilirsiniz<br>");
					Book b = list.get(i);
					request.setAttribute(kitapismi, b);
					out.println("<a href='kiralanacakkitaplar.xhtml'>Kitapi almak icin tiklayiniz</a>");
					return;
				}else if(list.get(i).getAdet()==0)
				{
					out.println("bu kitap suanda baska birine kiralanmis");
					out.println("<a href='odunckitap1.jsp'>Arama sayfasina donmek icin tiklayiniz</a>");
					return;
				}
			}
		}
		out.println("aradiginiz kitap bulunamamistir<br>");
		out.println("<a href='odunckitap1.jsp'>Arama sayfasina donmek icin tiklayiniz</a>");
	}

	

}
