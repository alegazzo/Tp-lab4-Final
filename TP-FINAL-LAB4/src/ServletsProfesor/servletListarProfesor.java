package ServletsProfesor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Docente;
import Helpers.Helpers;
import Negocio.NegocioDocente;

/**
 * Servlet implementation class servletListarProfesor
 */
@WebServlet("/servletListarProfesor")
public class servletListarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NegocioDocente negocioDocente = new NegocioDocente();
		ArrayList<Docente> listaDocentes = new ArrayList<Docente>(); 
		listaDocentes = negocioDocente.listarDocentes(); 
		
		request.setAttribute("listaDocentes", listaDocentes);
	    
		Helpers.redireccionar("VISTAS/VISTAS PROFESOR/ListarProfesores.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
