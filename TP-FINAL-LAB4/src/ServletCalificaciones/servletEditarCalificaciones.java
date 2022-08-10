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
import Negocio.NegocioCalificaciones;

/**
 * Servlet implementation class servletEditarCalificaciones
 */
@WebServlet("/servletEditarCalificaciones")
public class servletEditarCalificaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public servletEditarCalificaciones() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idCurso").toString()); 
		
		INegocioCalificaciones negocioCalificaciones = new NegocioCalificaciones();
        ArrayList<Calificaciones> listaCalificaciones = new ArrayList<Calificaciones>(); 
        
        listaCalificaciones = negocioCalificaciones.listarCalificaciones(id); 
        request.setAttribute("listaCalificaciones", listaCalificaciones);

        Helpers.redireccionar("VISTAS/CALIFICACIONES/EditarCalificacionesAlumnos.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("bandera")!=null){
            doGet(request, response);
            return;
        }
        
        
        ArrayList<Calificaciones> listaCalificaciones = new ArrayList<Calificaciones>();
        String idCurso = request.getParameter("idCurso").toString();
        String parcial1Array = request.getParameter("arrayparcial1").toString();
        String parcial2Array = request.getParameter("arrayparcial2").toString();
        String recuperatorio1Array = request.getParameter("arrayrecuperatorio1").toString();
        String recuperatorio2Array = request.getParameter("arrayrecuperatorio2").toString();
        String estadoArray = request.getParameter("arrayestado").toString();
        String idAlumnoArray = request.getParameter("arrayidAlumno").toString();
        
        String [] parcial1 = parcial1Array.split(",");
        String [] parcial2 = parcial2Array.split(",");
        String [] recuperatorio1 = recuperatorio1Array.split(",");
        String [] recuperatorio2 = recuperatorio2Array.split(",");
        String [] estado = estadoArray.split(",");
        String [] idAlumno = idAlumnoArray.split(",");

        
        for (int i = 0; i< idAlumno.length; i++) {
            Calificaciones cal = new Calificaciones();
            cal.setIdCurso(Integer.parseInt(idCurso));
            cal.setAlumno(new Alumno(Integer.parseInt(idAlumno[i])));
            cal.setParcial1(Float.parseFloat(parcial1[i]));
            cal.setParcial2(Float.parseFloat(parcial2[i]));
            cal.setRecuperatorio1(Float.parseFloat(recuperatorio1[i]));
            cal.setRecuperatorio2(Float.parseFloat(recuperatorio2[i]));
            cal.setEstadoAcademico(estado[i].equals("1") ? true : false );
            listaCalificaciones.add(cal);    
        }
        
        INegocioCalificaciones negocio = new NegocioCalificaciones();
        boolean flag = negocio.editarCalificaciones(listaCalificaciones);
        
        if(flag) {
            request.setAttribute("action", "Se modificaron las calififcaciones correctamente.");
            Helpers.redireccionar("ServletListarCalificaciones?id="+idCurso, request, response);
        }
        
	}

}
