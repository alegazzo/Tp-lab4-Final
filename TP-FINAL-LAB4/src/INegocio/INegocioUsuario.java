package INegocio;

import java.util.ArrayList;

import Dominio.Usuario;

public interface INegocioUsuario {
	
	public ArrayList<Usuario> listarUsuarios();
	public int agregarUsuario(Usuario usuario);
	public boolean eliminarUsuario(int idUsuario);
	public boolean modificarUsuario(Usuario usuario);

}
