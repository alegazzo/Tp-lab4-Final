package Dominio;

public class Carrera {
	private int idCarrera;
	private String nombreCarrera;
	private boolean estado;
	
	public Carrera() {
		super();
		idCarrera = 0;
		nombreCarrera = null;
		estado = false;
	}


	public Carrera(int idCarrera, String nombreCarrera, boolean estado) {
		super();
		this.idCarrera = idCarrera;
		this.nombreCarrera = nombreCarrera;
		this.estado = estado;
	}
	
	
	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
}
