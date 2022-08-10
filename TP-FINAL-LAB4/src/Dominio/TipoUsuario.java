package Dominio;

public class TipoUsuario {
	private int idTipoUsuario;
	private String nombreTipoUsuario;
	
	public TipoUsuario() {
		super();
		idTipoUsuario = 0;
		nombreTipoUsuario = null;
	}
	public TipoUsuario(int idTipoUsuario, String nombreTipoUsuario) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.nombreTipoUsuario = nombreTipoUsuario;
	}
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public String getNombreTipoUsuario() {
		return nombreTipoUsuario;
	}
	public void setNombreTipoUsuario(String nombreTipoUsuario) {
		this.nombreTipoUsuario = nombreTipoUsuario;
	}
	
}
