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
 * Servlet implementation class servletModificarUsuario
 */
@WebServlet("/servletModificarUsuario")
public class servletModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		int id = Integer.parseInt(request.getParameter("id")); 
		
		Usuario usuarioModificar = new Usuario();
		
		usuarioModificar = Helpers.encontrarUsuario(id); 
		
		Docente profeUsuario = Helpers.encontrarDocente(usuarioModificar.getReferencia());
	
		request.setAttribute("usuarioModificar", usuarioModificar);
		request.setAttribute("profeUsuario", profeUsuario);
		
		Helpers.redireccionar("VISTAS/VISTAS USUARIO/ModificarUsuario.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		Usuario usuarioModificar = new Usuario();
		
		usuarioModificar.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario").toString())); 
		usuarioModificar.setUser_Name(request.getParameter("user").toString());
		usuarioModificar.setPass(request.getParameter("pass").toString());
		
        NegocioUsuario NegUser = new NegocioUsuario(); 
		
		boolean estado = NegUser.modificarUsuario(usuarioModificar);  
		
		if(estado) {
        	request.setAttribute("action", "Se modificó el usuario correctamente");
	         Helpers.redireccionar("servletListarUsarios", request, response); 
        }
        
        else {
        	request.setAttribute("error", "Error al modificar el usuario");
			Helpers.redireccionar("ServletError", request, response);
        }
		
		
		
	}

}
