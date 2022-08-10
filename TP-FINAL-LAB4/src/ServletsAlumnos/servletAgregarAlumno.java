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
 * Servlet implementation class servletAgregarAlumno
 */
@WebServlet("/servletAgregarAlumno")
public class servletAgregarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Helpers.cargarPaises(request); 

        Helpers.cargarProvincias(request); 

        Helpers.cargarLocalidades(request); 

        Helpers.redireccionar("VISTAS/VISTAS ALUMNO/AddAlumno.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno AlumnoAdd = new Alumno(); 
        AlumnoAdd.setLegajo(request.getParameter("legajo").toString());
        AlumnoAdd.setDni(request.getParameter("dni").toString());
        AlumnoAdd.setNombre(request.getParameter("nombre").toString());
        AlumnoAdd.setApellido(request.getParameter("apellido").toString());
        AlumnoAdd.setEmail(request.getParameter("email").toString());
        AlumnoAdd.setTelefono(request.getParameter("telefono").toString());
        AlumnoAdd.setFecha_Nacimiento(LocalDate.parse(request.getParameter("fecha")));
        AlumnoAdd.setAdress(request.getParameter("direccion").toString());
        AlumnoAdd.setPais( 
                new Pais(Integer.parseInt(request.getParameter("paises").toString()))
                );
        AlumnoAdd.setProvincia( 
                new Provincia(Integer.parseInt(request.getParameter("provincias").toString()))
                );
        AlumnoAdd.setLocalidad( 
                new Localidad(Integer.parseInt(request.getParameter("localidades").toString()))
                );
        AlumnoAdd.setEstado(true);


        NegocioAlumno negocioAlumno = new NegocioAlumno();

         int estado = negocioAlumno.agregarAlumno(AlumnoAdd);
        
         switch(estado) {
         
         case -1:  request.setAttribute("error", " ERROR: Legajo o DNI repetido");
                   Helpers.redireccionar("ServletError", request, response);
         break; 
         
         case 0: request.setAttribute("error", "ERROR: no se pudo agregar el alumno");
                 Helpers.redireccionar("ServletError", request, response);
         break;
                 
         case 1:  request.setAttribute("action", "Se agregò el alumno correctamente");
		          Helpers.redireccionar("servletListarAlumnos", request, response); 
         break;
         }
          
	}

}
