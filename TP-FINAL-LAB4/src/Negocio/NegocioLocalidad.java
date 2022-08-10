package Negocio;

import java.util.ArrayList;
import Dao.DaoLocalidad;
import Dominio.Localidad;
import IDao.ILocalidad;
import INegocio.INegocioLocalidad;

public class NegocioLocalidad implements INegocioLocalidad {

	@Override
	public ArrayList<Localidad> listarLocalidades() {
		
     ILocalidad daoLocalidad = new DaoLocalidad(); 
		
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		
		localidades = daoLocalidad.listarLocalidades(); 
		
		return localidades; 
	}

}
