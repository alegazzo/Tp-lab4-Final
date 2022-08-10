package IDao;

import java.util.ArrayList;

import Dominio.Docente;

public interface IDocente {

	public ArrayList<Docente> listarDocentes();
	public int agregarDocente(Docente Docente);
	public boolean eliminarDocente(int idDocente);
	public boolean modificarDocente(Docente Docente);
	
}
