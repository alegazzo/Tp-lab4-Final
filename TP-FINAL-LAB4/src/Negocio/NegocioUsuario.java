package Negocio;

import java.util.ArrayList;

import Dao.DaoAlumno;
import Dao.DaoUsuario;
import Dominio.Alumno;
import Dominio.Usuario;
import IDao.IUsuario;
import INegocio.INegocioUsuario;

public class NegocioUsuario implements INegocioUsuario {

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		DaoUsuario daoUsuario = new DaoUsuario();
		ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
		Usuarios = daoUsuario.listarUsuarios();
		return Usuarios;
	}

	@Override
	public int agregarUsuario(Usuario usuario) {
		
		if(validarUserName(usuario.getUser_Name())) return -1;
		
		IUsuario NegUser = new DaoUsuario();
		
		int estado = NegUser.agregarUsuario(usuario)? 1:0; 
		
		return estado;
	}

	@Override
	public boolean eliminarUsuario(int idUsuario) {
		
		IUsuario NegUser = new DaoUsuario();
		
		boolean estado = NegUser.eliminarUsuario(idUsuario); 
		
		return estado;
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) {
		
        IUsuario NegUser = new DaoUsuario();
		
		boolean estado = NegUser.modificarUsuario(usuario); 
		
		return estado;
	}
	
	 public boolean validarUserName( String username) {
			
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = listarUsuarios();
			for(Usuario usuario: usuarios) {
				 
				 if(usuario.getUser_Name().equals(username)) {
					 return true;
				 }
			}
		 	 return false; 
		  }
	 
	 public int validarLogin(String user, String pass) {
		 
		 ArrayList<Usuario> usuarios = listarUsuarios();
		 
		 for(Usuario usuario : usuarios) 
		 {
			 if(usuario.getUser_Name().equals(user)&&usuario.getPass().equals(pass)) {
				 return usuario.getIdUsuario() ; 
			 }
		 }
		 
		 return 0;
	 }
	 
	

}
