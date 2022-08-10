package ServletsProfesor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoPais;
import Dominio.Docente;
import Dominio.Localidad;
import Dominio.Pais;
import Dominio.Provincia;
import Helpers.Helpers;
import IDao.IPais;
import INegocio.INegocioPais;
import Negocio.NegocioDocente;
import Negocio.NegocioPais;

/**
 * Servlet implementation class servletModificarProfesor
 */
@WebServlet("/servletModificarProfesor")
public class servletModificarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id")); 
		
		Docente docenteModificar = new Docente();
		
		docenteModificar = Helpers.encontrarDocente(id); 
	
		request.setAttribute("docenteModificar", docenteModificar);
		
		Helpers.cargarPaises(request); 
		
		Helpers.cargarProvincias(request); 
		
		Helpers.cargarLocalidades(request); 
		
		Helpers.redireccionar("VISTAS/VISTAS PROFESOR/ModificarProfesor.jsp", request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Docente docenteMod = new Docente(); 
		docenteMod.setIdDocente(Integer.parseInt(request.getParameter("idProfesor")));
		docenteMod.setNombre(request.getParameter("nombre").toString());
		docenteMod.setApellido(request.getParameter("apellido").toString());
		docenteMod.setEmail(request.getParameter("email").toString());
		docenteMod.setTelefono(request.getParameter("telefono").toString());
		docenteMod.setFecha_Nacimiento(LocalDate.parse(request.getParameter("fecha")));  
		docenteMod.setAdress(request.getParameter("direccion").toString());
		docenteMod.setPais( 
				new Pais(Integer.parseInt(request.getParameter("paises").toString()))
				);
		docenteMod.setProvincia( 
				new Provincia(Integer.parseInt(request.getParameter("provincias").toString()))
				);
		docenteMod.setLocalidad( 
				new Localidad(Integer.parseInt(request.getParameter("localidades").toString()))
				);
		docenteMod.setEstado(true);
		
		
		NegocioDocente negocioDocente = new NegocioDocente();
		
		 boolean estado = negocioDocente.modificarDocente(docenteMod); 
		 
		 if(estado) {
			 request.setAttribute("action", "Se modificó el profesor correctamente");
			 Helpers.redireccionar("servletListarProfesor", request, response); 
		 }
		 else {
			 request.setAttribute("error", "no se pudo modificar el docente");
				Helpers.redireccionar("ServletError", request, response);
		 }
		
		
		
		
	}
	
	

	
	
	

}
