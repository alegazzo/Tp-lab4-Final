package servletsCurso;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Curso;
import Dominio.Docente;
import Helpers.Helpers;
import Negocio.NegocioCurso;
import Negocio.NegocioDocente;

/**
 * Servlet implementation class servletListarCurso
 */
@WebServlet("/servletListarCurso")
public class servletListarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NegocioCurso negocioCurso = new NegocioCurso();
		ArrayList<Curso> listaCursos = new ArrayList<Curso>(); 
		listaCursos = negocioCurso.listarCursos(); 
		System.out.println(listaCursos.size());
		request.setAttribute("listaCursos", listaCursos);
	    
		Helpers.redireccionar("VISTAS/CURSOS/TodosLosCursos.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
