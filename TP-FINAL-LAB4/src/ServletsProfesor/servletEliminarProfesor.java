package ServletsProfesor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Docente;
import Helpers.Helpers;
import INegocio.INegocioDocente;
import Negocio.NegocioDocente;

/**
 * Servlet implementation class servletEliminarProfesor
 */
@WebServlet("/servletEliminarProfesor")
public class servletEliminarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        int id = Integer.parseInt(request.getParameter("id")); 
		
		Docente docenteEliminar = new Docente();
		
		docenteEliminar = Helpers.encontrarDocente(id); 
	
		request.setAttribute("docenteEliminar", docenteEliminar);
		
		Helpers.cargarPaises(request); 
		
		Helpers.cargarProvincias(request); 
		
		Helpers.cargarLocalidades(request); 
		
		Helpers.redireccionar("VISTAS/VISTAS PROFESOR/EliminarProfesor.jsp", request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("idProfesor"));
		
		INegocioDocente negocioDocente = new NegocioDocente(); 
		
		boolean estado = negocioDocente.eliminarDocente(id); 
		
		if(estado) {
			 request.setAttribute("action", "Se elimimnó el profesor correctamente");
			Helpers.redireccionar("servletListarProfesor", request, response);
		}
		else {
			 request.setAttribute("error", "no se pudo modificar el docente");
				Helpers.redireccionar("ServletError", request, response);
		 }
		
		
		
	}

}
