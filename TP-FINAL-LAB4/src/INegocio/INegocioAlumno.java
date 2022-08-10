package INegocio;

import java.util.ArrayList;

import Dominio.Alumno;

public interface INegocioAlumno {
	public ArrayList<Alumno> listarAlumnos();
	public int agregarAlumno(Alumno alumno);
	public boolean eliminarAlumno(int idAlumno);
	public boolean modificarAlumno(Alumno alumno);
}
