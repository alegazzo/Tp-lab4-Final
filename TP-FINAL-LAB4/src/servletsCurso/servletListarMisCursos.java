package servletsCurso;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Curso;
import Dominio.Usuario;
import Helpers.Helpers;
import Negocio.NegocioCurso;

/**
 * Servlet implementation class servletListarMisCursos
 */
@WebServlet("/servletListarMisCursos")
public class servletListarMisCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarMisCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Usuario userDocente  =(Usuario)request.getSession().getAttribute("usuario");
		
		NegocioCurso negocioCurso = new NegocioCurso();
		ArrayList<Curso> listaMisCursos = new ArrayList<Curso>(); 
		listaMisCursos = negocioCurso.listarMisCursos(userDocente.getReferencia()); 
		request.setAttribute("listaMisCursos", listaMisCursos);
	    
		Helpers.redireccionar("VISTAS/CURSOS/MisCursos.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
