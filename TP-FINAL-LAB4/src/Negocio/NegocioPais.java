package Negocio;

import java.util.ArrayList;

import Dao.DaoPais;
import Dominio.Pais;
import IDao.IPais;
import INegocio.INegocioPais;

public class NegocioPais implements INegocioPais {

	@Override
	public ArrayList<Pais> listarPaises() {
		 
		IPais daoPais = new DaoPais(); 
		
		ArrayList<Pais> paises = new ArrayList<Pais>();
		
		paises = daoPais.listarPaises(); 
		
		return paises;
	}

}
