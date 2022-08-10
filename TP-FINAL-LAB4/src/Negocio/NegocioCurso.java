package Negocio;

import java.util.ArrayList;

import Dao.DaoCurso;
import Dominio.Curso;
import IDao.ICurso;
import INegocio.INegocioCurso;

public class NegocioCurso implements INegocioCurso{

	
	public ArrayList<Curso> listarCursos() {
		ICurso daoCurso = new DaoCurso();
		ArrayList<Curso> cursos = new ArrayList<Curso>(); 
		cursos = daoCurso.listarCursos();
		return cursos;
	}

	
	public ArrayList<Curso> listarMisCursos(int idProfesor) {
		ICurso daoCurso = new DaoCurso();
		ArrayList<Curso> cursos = new ArrayList<Curso>(); 
		cursos = daoCurso.listarMisCursos(idProfesor);
		return cursos;
	}
	
	public boolean agregarCursos (Curso curso) {
		ICurso daoCurso = new DaoCurso();
		boolean estado = daoCurso.AgregarCurso(curso);
		return estado;
	}

}
