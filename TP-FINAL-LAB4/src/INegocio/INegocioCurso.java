package INegocio;

import java.util.ArrayList;

import Dominio.Curso;

public interface INegocioCurso {
	
	public ArrayList<Curso> listarCursos();

	public ArrayList<Curso> listarMisCursos(int idProfesor); 

	public boolean agregarCursos (Curso curso);
}
