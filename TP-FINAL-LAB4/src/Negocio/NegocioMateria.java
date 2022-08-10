package Negocio;

import java.util.ArrayList;
import Dao.DaoMateria;
import Dominio.Materia;
import IDao.IMateria;
import INegocio.INegocioMateria;

public class NegocioMateria implements INegocioMateria{

	
	public ArrayList<Materia> listarMaterias() {
		IMateria daoMateria = new DaoMateria(); 
		
		ArrayList<Materia> materias = new ArrayList<Materia>();
		
		materias = daoMateria.listarMaterias(); 
		
		return materias; 
	}
	
}
