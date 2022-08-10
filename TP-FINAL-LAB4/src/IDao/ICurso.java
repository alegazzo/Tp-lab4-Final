package IDao;

import java.util.ArrayList;

import Dominio.Alumno;
import Dominio.Curso;


public interface ICurso { 
	
	public ArrayList<Curso> listarCursos();

	public ArrayList<Curso> listarMisCursos(int idProfesor); 
	
	public boolean AgregarCurso(Curso curso);
	
	public boolean AgregarAlumnosDeCurso (Alumno alumno, int idCurso);
	
	public boolean AgregarCalificacionesAlumno (int idAlumno, int idCurso);
}
