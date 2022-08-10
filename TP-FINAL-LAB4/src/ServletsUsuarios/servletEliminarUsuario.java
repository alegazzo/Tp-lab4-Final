package ServletsUsuarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Docente;
import Dominio.Usuario;
import Helpers.Helpers;
import INegocio.INegocioUsuario;
import Negocio.NegocioUsuario;

/**
 * Servlet implementation class servletEliminarUsuario
 */
@WebServlet("/servletEliminarUsuario")
public class servletEliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); 
		
		Usuario usuarioEliminar = new Usuario();
		
		usuarioEliminar = Helpers.encontrarUsuario(id); 
		
		Docente profeUsuario = Helpers.encontrarDocente(usuarioEliminar.getReferencia());
	
		request.setAttribute("usuarioEliminar", usuarioEliminar);
		request.setAttribute("profeUsuario", profeUsuario);
		
		Helpers.redireccionar("VISTAS/VISTAS USUARIO/EliminarUsuario.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("idUsuario")); 
		
		INegocioUsuario NegUser = new NegocioUsuario(); 
		
		boolean estado = NegUser.eliminarUsuario(id); 
		
		if(estado) {
        	request.setAttribute("action", "Se eliminó el usuario correctamente");
	         Helpers.redireccionar("servletListarUsarios", request, response); 
        }
        
        else {
        	request.setAttribute("error", "Error al eliminar el usuario");
			Helpers.redireccionar("ServletError", request, response);
        }
	}

}
