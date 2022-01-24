import java.io.IOException;
import ejb.bean;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/")
public class Essaie extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    public Essaie() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	HttpSession session = request.getSession();
    	session.setAttribute("EJB1",myEJB);
        this.getServletContext().getRequestDispatcher("/WEB-INF/web1.jsp").forward(request, response);
        

    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    @EJB
    bean myEJB;
   

}