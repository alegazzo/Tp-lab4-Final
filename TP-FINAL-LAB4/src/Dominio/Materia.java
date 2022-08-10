package Dominio;

public class Materia {
	@Override
	public String toString() {
		return "Materia [idMateria=" + idMateria + ", nombreMateria=" + nombreMateria + "]";
	}
	private int idMateria;
	private String nombreMateria;
	private boolean estado;
	private Carrera carrera;

	public Materia() {
		super();
		idMateria = 0;
		nombreMateria = null;
		estado = false;
		carrera = null;
	}
	
	public Materia (int id) {
		idMateria = id;
	}
	
	public Materia( int id, String nombre) {
		
		idMateria = id;
		nombreMateria = nombre;
	}
	
	
	
	public Materia(int idMateria, String nombreMateria, boolean estado, Carrera carrera) {
		super();
		this.idMateria = idMateria;
		this.nombreMateria = nombreMateria;
		this.estado = estado;
		this.carrera = carrera;
	}
	
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
}
