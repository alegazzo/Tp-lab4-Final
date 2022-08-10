package ServletsUsuarios;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Docente;
import Dominio.Usuario;
import Helpers.Helpers;
import Negocio.NegocioDocente;
import Negocio.NegocioUsuario;

/**
 * Servlet implementation class servletListarUsarios
 */
@WebServlet("/servletListarUsarios")
public class servletListarUsarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarUsarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NegocioUsuario negocioUsuario = new NegocioUsuario();
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>(); 
		listaUsuarios = negocioUsuario.listarUsuarios(); 
		
		request.setAttribute("listaUsuarios", listaUsuarios);
	    
		Helpers.redireccionar("VISTAS/VISTAS USUARIO/ListarUsuarios.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
