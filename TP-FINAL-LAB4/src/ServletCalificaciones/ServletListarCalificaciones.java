package ServletCalificaciones;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Alumno;
import Dominio.Calificaciones;
import Helpers.Helpers;
import INegocio.INegocioCalificaciones;
import Negocio.NegocioAlumno;
import Negocio.NegocioCalificaciones;


@WebServlet("/ServletListarCalificaciones")
public class ServletListarCalificaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletListarCalificaciones() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id").toString()); 
		
		INegocioCalificaciones negocioCalificaciones = new NegocioCalificaciones();
        ArrayList<Calificaciones> listaCalificaciones = new ArrayList<Calificaciones>(); 
        listaCalificaciones = negocioCalificaciones.listarCalificaciones(id); 

        request.setAttribute("listaCalificaciones", listaCalificaciones);
        request.setAttribute("idCurso", id);
        Helpers.redireccionar("VISTAS/CALIFICACIONES/ListarCalificaciones.jsp", request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
