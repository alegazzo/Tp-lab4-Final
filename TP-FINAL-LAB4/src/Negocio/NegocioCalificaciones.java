package Negocio;

import java.util.ArrayList;

import Dao.DaoCalificaciones;
import Dao.DaoCurso;
import Dominio.Calificaciones;
import Dominio.Curso;
import IDao.ICalificaciones;
import IDao.ICurso;
import INegocio.INegocioCalificaciones;

public class NegocioCalificaciones implements INegocioCalificaciones{
	
	
	public ArrayList<Calificaciones> listarCalificaciones(int id) {
		ICalificaciones dao= new DaoCalificaciones();
		ArrayList<Calificaciones> calificaciones = new ArrayList<Calificaciones>(); 
		calificaciones = dao.listarCalificaciones(id);
		return calificaciones;
	}
	
	
	public boolean editarCalificaciones(ArrayList<Calificaciones> calificaciones) {
		ICalificaciones daoCalificaciones = new DaoCalificaciones();
		for (Calificaciones cal : calificaciones){
			
			daoCalificaciones.EditarCalificacionesCurso(cal);	
		}
		return true;
	}
	
}
