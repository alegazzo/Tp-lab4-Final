package IDao;

import java.util.ArrayList;

import Dominio.Usuario;

public interface IUsuario {

	
	public ArrayList<Usuario> listarUsuarios();
	public boolean agregarUsuario(Usuario usuario);
	public boolean eliminarUsuario(int idUsuario);
	public boolean modificarUsuario(Usuario usuario);
	
}
