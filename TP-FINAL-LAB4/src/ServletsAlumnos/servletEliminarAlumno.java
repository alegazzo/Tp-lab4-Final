package ServletsAlumnos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Alumno;
import Helpers.Helpers;
import INegocio.INegocioAlumno;
import Negocio.NegocioAlumno;

/**
 * Servlet implementation class servletEliminarAlumno
 */
@WebServlet("/servletEliminarAlumno")
public class servletEliminarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); 

        Alumno AlumnoEliminar = new Alumno();

        AlumnoEliminar = Helpers.encontrarAlumno(id); 
        
        
        request.setAttribute("AlumnoEliminar", AlumnoEliminar);

        Helpers.cargarPaises(request); 

        Helpers.cargarProvincias(request); 

        Helpers.cargarLocalidades(request); 

        Helpers.redireccionar("VISTAS/VISTAS ALUMNO/EliminarAlumno.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idAlumno"));

        INegocioAlumno negocioAlumno = new NegocioAlumno(); 

        boolean estado = negocioAlumno.eliminarAlumno(id); 

        if(estado) {
        	request.setAttribute("action", "Se eliminó el alumno correctamente");
	         Helpers.redireccionar("servletListarAlumnos", request, response); 
        }
        
        else {
        	request.setAttribute("error", "Error al eliminar al alumno");
			Helpers.redireccionar("ServletError", request, response);
        }

	}

}
