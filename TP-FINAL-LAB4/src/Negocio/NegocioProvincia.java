package Negocio;
import java.util.ArrayList;
import Dao.DaoProvincias;
import Dominio.Provincia;
import IDao.IProvincia;
import INegocio.INegocioProvincia;

public class NegocioProvincia implements INegocioProvincia {

	@Override
	public ArrayList<Provincia> listarProvincias() {
		
          IProvincia daoProv = new DaoProvincias(); 
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();
		
		provincias = daoProv.listarProvincias(); 
		
		return provincias;
	}

}
