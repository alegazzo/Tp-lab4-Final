package Negocio;

import java.util.ArrayList;

import Dao.DaoAlumno;
import Dominio.Alumno;
import Dominio.Docente;
import INegocio.INegocioAlumno;

public class NegocioAlumno implements INegocioAlumno{
	


	@Override
	public ArrayList<Alumno> listarAlumnos() {
		DaoAlumno daoalumno = new DaoAlumno();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos = daoalumno.listarAlumnos();
		return alumnos;
	}

	@Override
	public int agregarAlumno(Alumno alumno) {
		if(validarDNILegajoAlum(alumno)) return -1;
		DaoAlumno daoalumno = new DaoAlumno();
		int estado = daoalumno.agregarAlumno(alumno)? 1 : 0;
		return estado;
	}

	@Override
	public boolean eliminarAlumno(int idAlumno) {
		DaoAlumno daoalumno = new DaoAlumno();
		boolean estado = daoalumno.eliminarAlumno(idAlumno);
		return estado;
	}

	@Override
	public boolean modificarAlumno(Alumno alumno) {
		DaoAlumno daoalumno = new DaoAlumno();
		boolean estado = daoalumno.modificarAlumno(alumno);
		return estado;
	}
	
	
	 public boolean validarDNILegajoAlum(Alumno alumno) {
			
			ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
			alumnos = listarAlumnos();
			for(Alumno alum : alumnos) {
				 
				 if(alum.getDni().equalsIgnoreCase(alumno.getDni()) || alum.getLegajo().equalsIgnoreCase(alumno.getLegajo())) {
					 return true;
				 }
			}
		 	 return false; 
		  }
	
	
}
