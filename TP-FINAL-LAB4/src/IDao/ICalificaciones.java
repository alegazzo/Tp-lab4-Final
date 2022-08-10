package IDao;

import java.util.ArrayList;

import Dominio.Alumno;
import Dominio.Calificaciones;

public interface ICalificaciones{

	
	public ArrayList<Calificaciones> listarCalificaciones(int IdCurso);
	
	public boolean EditarCalificacionesCurso (Calificaciones calificaciones);
	
}
