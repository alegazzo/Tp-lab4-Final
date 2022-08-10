package ServletsAlumnos;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Alumno;
import Dominio.Localidad;
import Dominio.Pais;
import Dominio.Provincia;
import Helpers.Helpers;
import Negocio.NegocioAlumno;

/**
 * Servlet implementation class servletModificarAlumno
 */
@WebServlet("/servletModificarAlumno")
public class servletModificarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id")); 

        Alumno AlumnoModificar = new Alumno();
        
        

        AlumnoModificar = Helpers.encontrarAlumno(id); 
        
        
        request.setAttribute("AlumnoModificar", AlumnoModificar);

        Helpers.cargarPaises(request); 

        Helpers.cargarProvincias(request); 

        Helpers.cargarLocalidades(request); 

        Helpers.redireccionar("VISTAS/VISTAS ALUMNO/ModificarAlumno.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno AlumnoMod = new Alumno(); 
        AlumnoMod.setIdAlumno(Integer.parseInt(request.getParameter("idAlumno")));
        AlumnoMod.setNombre(request.getParameter("nombre").toString());
        AlumnoMod.setApellido(request.getParameter("apellido").toString());
        AlumnoMod.setEmail(request.getParameter("email").toString());
        AlumnoMod.setTelefono(request.getParameter("telefono").toString());
        AlumnoMod.setFecha_Nacimiento(LocalDate.parse(request.getParameter("fecha")));
        AlumnoMod.setAdress(request.getParameter("direccion").toString());
        AlumnoMod.setPais( 
                new Pais(Integer.parseInt(request.getParameter("paises").toString()))
                );
        AlumnoMod.setProvincia( 
                new Provincia(Integer.parseInt(request.getParameter("provincias").toString()))
                );
        AlumnoMod.setLocalidad( 
                new Localidad(Integer.parseInt(request.getParameter("localidades").toString()))
                );
        AlumnoMod.setEstado(true);


        NegocioAlumno negocioAlumno = new NegocioAlumno();

        boolean estado = negocioAlumno.modificarAlumno(AlumnoMod); 
        
        if(estado) {
        	request.setAttribute("action", "Se modificó el alumno correctamente");
	         Helpers.redireccionar("servletListarAlumnos", request, response); 
        }
        
        else {
        	request.setAttribute("error", "Error el guardar el alumno modificado");
			Helpers.redireccionar("ServletError", request, response);
        }

        
	}
}


