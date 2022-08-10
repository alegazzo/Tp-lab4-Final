package Dominio;


public class Provincia {
	private int idProvincia;
	private String nombreProvincia;
	private int idPais;
	
	
	public String getNombreProvincia() {
		return nombreProvincia;
	}


	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}


	@Override
	public String toString() {
		return "Provincia [idProvincia=" + idProvincia + ", nombreProvincia=" + nombreProvincia + ", idPais=" + idPais
				+ "]";
	}


	public Provincia () {
		super();
		idProvincia = 0;
		nombreProvincia = null;
		idPais = 0;
	}
	
	public Provincia ( int id) {
		
		idProvincia = id;
		
	}


	public Provincia(int idProvincia, String nombreProvincia, int pais) {
		super();
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;
		this.idPais = pais;
	}


	public int getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}


	public int getPais() {
		return idPais;
	}


	public void setPais(int pais) {
		this.idPais = pais;
	}
	
	
	
	
	
}
