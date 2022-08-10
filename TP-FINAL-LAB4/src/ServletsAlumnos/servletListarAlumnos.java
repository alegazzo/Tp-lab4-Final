package ServletsAlumnos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Alumno;
import Helpers.Helpers;
import Negocio.NegocioAlumno;

/**
 * Servlet implementation class servletListarAlumnos
 */
@WebServlet("/servletListarAlumnos")
public class servletListarAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NegocioAlumno negocioAlumno = new NegocioAlumno();
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(); 
        listaAlumnos = negocioAlumno.listarAlumnos(); 

        request.setAttribute("listaAlumnos", listaAlumnos);

        Helpers.redireccionar("VISTAS/VISTAS ALUMNO/ListarAlumnos.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
