package IDao;

import java.util.ArrayList;

import Dominio.Alumno;

public interface IAlumno {
	public ArrayList<Alumno> listarAlumnos();
	public boolean agregarAlumno(Alumno alumno);
	public boolean eliminarAlumno(int idAlumno);
	public boolean modificarAlumno(Alumno alumno);
}
