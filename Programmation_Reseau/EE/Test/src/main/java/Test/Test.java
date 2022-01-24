package Test;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.Ejb;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	Ejb myEJB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.http.HttpSession session = request.getSession();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher vue =request.getRequestDispatcher("/WEB-INF/essai.jsp");
		session.setAttribute("myEJB",myEJB);
		vue.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.http.HttpSession session = request.getSession();
		String url = request.getRequestURL()+"?";
        String nomPerson = request.getParameter("nomPersonnage");
        String caracter = request.getParameter("caracteristique");
		//getParameter;
		session.setAttribute("nomPerso",nomPerson) ;
		session.setAttribute("cara",caracter) ;
	    response.sendRedirect(url+"nomPersonnage="+nomPerson+"&caracteristique="+caracter);
	        
		
	}

}
