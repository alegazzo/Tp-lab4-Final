package INegocio;

import java.util.ArrayList;

import Dao.DaoCalificaciones;
import Dominio.Calificaciones;
import IDao.ICalificaciones;

public interface INegocioCalificaciones {
	
	public ArrayList<Calificaciones> listarCalificaciones(int id);
	
	public boolean editarCalificaciones(ArrayList<Calificaciones> calificaciones);
			
}
