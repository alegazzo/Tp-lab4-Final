package Dominio;

public class Pais {
	private int idPais;
	private String nombrePais;
	
	public Pais () {
		super();
		idPais = 0;
		nombrePais = null;		
	}

	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", nombrePais=" + nombrePais + "]";
	}

	public Pais(int idPais, String nombrePais) {
		super();
		this.idPais = idPais;
		this.nombrePais = nombrePais;
	}
	
	public Pais(int idPais) {
		this.idPais = idPais;
	}

	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

}
