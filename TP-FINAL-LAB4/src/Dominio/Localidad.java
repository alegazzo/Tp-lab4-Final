package Dominio;

public class Localidad {
	private int idLocalidad;
	private int idProvincia;
	private String nombreLocalidad;
	
	public Localidad() {
		super();
		this.idLocalidad = 0;
		this.idProvincia = 0;
		this.nombreLocalidad = null;
	}
	
	
	@Override
	public String toString() {
		return "Localidad [idLocalidad=" + idLocalidad + ", idProvincia=" + idProvincia + ", nombreLocalidad="
				+ nombreLocalidad + "]";
	}


	public Localidad(int idLocalidad, int provincia, String nombreLocalidad) {
		super();
		this.idLocalidad = idLocalidad;
		this.idProvincia = provincia;
		this.nombreLocalidad = nombreLocalidad;
	}
	
	public Localidad(int idLocalidad) {

		this.idLocalidad = idLocalidad;
	}
	

	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public int getProvincia() {
		return idProvincia;
	}
	public void setProvincia(int provincia) {
		this.idProvincia = provincia;
	}
	public String getNombre() {
		return nombreLocalidad;
	}
	public void setNombre(String nombre) {
		this.nombreLocalidad = nombre;
	}



}
