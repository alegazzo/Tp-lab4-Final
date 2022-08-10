package ServletsProfesor;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Docente;
import Dominio.Localidad;
import Dominio.Pais;
import Dominio.Provincia;
import Helpers.Helpers;
import INegocio.INegocioDocente;
import Negocio.NegocioDocente;

/**
 * Servlet implementation class servletAgregarProfesor
 */
@WebServlet("/servletAgregarProfesor")
public class servletAgregarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarProfesor() {
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
		
		Helpers.redireccionar("VISTAS/VISTAS PROFESOR/AddProfesor.jsp", request, response);	
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Docente docenteAdd = new Docente(); 
		docenteAdd.setLegajo(request.getParameter("legajo").toString());
		docenteAdd.setDni(request.getParameter("dni").toString());
		docenteAdd.setNombre(request.getParameter("nombre").toString());
		docenteAdd.setApellido(request.getParameter("apellido").toString());
		docenteAdd.setEmail(request.getParameter("email").toString());
		docenteAdd.setTelefono(request.getParameter("telefono").toString());
		docenteAdd.setFecha_Nacimiento(LocalDate.parse(request.getParameter("fecha")));  
		docenteAdd.setAdress(request.getParameter("direccion").toString());
		docenteAdd.setPais( 
				new Pais(Integer.parseInt(request.getParameter("paises").toString()))
				);
		docenteAdd.setProvincia( 
				new Provincia(Integer.parseInt(request.getParameter("provincias").toString()))
				);
		docenteAdd.setLocalidad( 
				new Localidad(Integer.parseInt(request.getParameter("localidades").toString()))
				);
		docenteAdd.setEstado(true);
		
		
		NegocioDocente negocioDocente = new NegocioDocente();
		
		 int idGenerado = negocioDocente.agregarDocente(docenteAdd);
		 if(idGenerado>0) {
			 request.setAttribute("idGenerado", idGenerado);
			 request.setAttribute("nuevoUser", docenteAdd.getNombre() + " " + docenteAdd.getApellido());
			
			request.setAttribute("action", "Se agregó el profesor correctamente correctamente");
			Helpers.redireccionar("servletUserProfesor?id=1", request, response); 	
		 }
		 else 
		 {
			 if(idGenerado == -1) 
			 {
				 request.setAttribute("error", " ERROR: Legajo o DNI repetido");
				
			 }
			 else {
					request.setAttribute("error", "ERROR: no se pudo agregar el docente");
					
			 }
			  
			 Helpers.redireccionar("ServletError", request, response);
		 }
		
		 
			
	}

}
