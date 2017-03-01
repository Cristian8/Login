package sesion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logeo
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        
        HttpSession sesion = request.getSession();
        
        if(action.equals("/out"))
        {
            sesion.invalidate();
            response.sendRedirect("inicio.jsp");
        }
        else
        {
        	 sesion.invalidate();
             response.sendRedirect("inicio.jsp");
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String usu;
        usu = request.getParameter("user");
		
        if(sesion.getAttribute("usuario") == null){
            
            sesion.setAttribute("usuario", usu);
            
            response.sendRedirect("usuarioCreado.jsp");
        }
        else
        {
            sesion.invalidate();
            response.sendRedirect("inicio.jsp");
        }
	}

}
