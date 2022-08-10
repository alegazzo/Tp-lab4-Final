package servletLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Usuario;
import Helpers.Helpers;
import Negocio.NegocioUsuario;

/**
 * Servlet implementation class servletLogin
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String user = request.getParameter("user").toString();
		 String pass = request.getParameter("pass").toString();
		 
		 NegocioUsuario negUser = new NegocioUsuario();
		 int id = negUser.validarLogin(user, pass);
		 
		 if(id>0) {
			 
			 Usuario usuario = new Usuario(); 
			 usuario = Helpers.encontrarUsuario(id); 
			 request.getSession().setAttribute("usuario", usuario);
			 Helpers.redireccionar("VISTAS/HOME.jsp", request, response);
			 
		 }
		 
		 else {
			 
			 Helpers.redireccionar("VISTAS/ERROR/ErrorLogin.jsp", request, response);
		 }
		
	}

}
