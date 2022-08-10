package servletsCurso;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Docente;
import Dominio.Materia;
import Dominio.Usuario;
import Helpers.Helpers;
import Negocio.NegocioAlumno;
import Negocio.NegocioCurso;
import Negocio.NegocioDocente;
import Negocio.NegocioMateria;
import Negocio.NegocioUsuario;

/**
 * Servlet implementation class servletAgregarCurso
 */
@WebServlet("/servletAgregarCurso")
public class servletAgregarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarCurso() {
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
		
		NegocioAlumno negocioAlumno = new NegocioAlumno();
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(); 
		listaAlumnos = negocioAlumno.listarAlumnos(); 
		
		request.setAttribute("listaAlumnos", listaAlumnos);
		
		NegocioMateria negocioMateria = new NegocioMateria();
		ArrayList<Materia> listaMaterias = new ArrayList<Materia>(); 
		listaMaterias = negocioMateria.listarMaterias(); 
		
		request.setAttribute("listaMaterias", listaMaterias);
		
		Helpers.redireccionar("VISTAS/CURSOS/AgregarCurso.jsp", request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		Curso cursoAdd = new Curso();
		cursoAdd.setNombre(request.getParameter("nombreCurso"));
		cursoAdd.setSemestre(request.getParameter("semestreCurso"));
		cursoAdd.setAnio(request.getParameter("anioCurso"));
		cursoAdd.setDocente(new Docente(Integer.parseInt(request.getParameter("Profesor").toString())));
		cursoAdd.setMateria(new Materia (Integer.parseInt(request.getParameter("Materia").toString())));
		cursoAdd.setEstado(true);
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		String arrayid = request.getParameter("arrayid");
		String [] id= arrayid.split(",");
		System.out.println(); 
		for (int i = 0; i< id.length; i++) {
			System.out.println(id[i]); 
			Alumno alumno = new Alumno(Integer.parseInt(id[i]));
			listaAlumnos.add(alumno);
		}

		cursoAdd.setListaAlumnos(listaAlumnos);
		
		NegocioCurso negCurso = new NegocioCurso();
		
		 boolean flag = negCurso.agregarCursos(cursoAdd);
		if(flag) {
			request.setAttribute("action", "Se agregó el curso correctamente");
			Helpers.redireccionar("servletListarCurso", request, response);
			
		}
		
		
		
		
		
	}

}
