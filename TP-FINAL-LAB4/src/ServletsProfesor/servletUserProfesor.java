package ServletsProfesor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Docente;
import Dominio.TipoUsuario;
import Dominio.Usuario;
import Helpers.Helpers;
import INegocio.INegocioDocente;
import INegocio.INegocioUsuario;
import Negocio.NegocioDocente;
import Negocio.NegocioUsuario;

/**
 * Servlet implementation class servletUserProfesor
 */
@WebServlet("/servletUserProfesor")
public class servletUserProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletUserProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		
		 int id = Integer.parseInt(request.getAttribute("idGenerado").toString()); 
		 
//		 Docente docenteUser = new Docente();
//			
//		 docenteUser = Helpers.encontrarDocente(id); 
//		 
//		 request.setAttribute("docenteUser", docenteUser); 
//		 
		 Helpers.redireccionar("VISTAS/VISTAS PROFESOR/UserProfesor.jsp", request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		if(request.getParameter("id")!=null){
			doGet(request, response);
			return;
		}
		
		int referencia = Integer.parseInt(request.getParameter("referencia").toString()); 
		String usuario = request.getParameter("usuario").toString(); 
		String pass =  request.getParameter("pass").toString(); 
		
		INegocioUsuario NegUser = new NegocioUsuario(); 
		
		Usuario user = new Usuario();
		
		
		user.setReferencia(referencia);
		user.setUser_Name(usuario);
		user.setPass(pass);
		user.setTipoUsuario(new TipoUsuario(2, "profesor"));
		user.setEstado(true);
		
		int estado = NegUser.agregarUsuario(user); 
		
		switch(estado) {
        
        case -1:  request.setAttribute("idGenerado", user.getReferencia()); 
                  Docente docenteUser = Helpers.encontrarDocente(user.getReferencia()); 
                  request.setAttribute("nuevoUser", docenteUser.getNombre() + " " + docenteUser.getApellido());
        	      request.setAttribute("errorUserName", "nombre de usuario no disponible");
                  doGet(request, response);
        break; 
                 
        case 0:   
        	    NegocioDocente docenteEliminar =  new NegocioDocente(); 
        	    docenteEliminar.eliminarDocente(referencia);
        	    request.setAttribute("error", "ERROR: no se pudo agregar el usuario");
                Helpers.redireccionar("ServletError", request, response);
        break;
                
        case 1:  request.setAttribute("action", "Se agregó el usuario correctamente");
		          Helpers.redireccionar("servletListarProfesor", request, response); 
        break;
        }
	}

}
