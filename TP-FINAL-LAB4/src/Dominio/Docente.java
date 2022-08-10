package Dominio;

import java.time.LocalDate;

public class Docente {
	private int idDocente;
	private String legajo;
	private String dni;
	private String nombre;
	private String apellido;
	private LocalDate fecha_Nacimiento;
	private String adress;
	private Localidad localidad;
	private Provincia provincia;
	private Pais pais;
	private String email;
	private String telefono;
	private boolean estado;
	
	

	public Docente() {
		super();
	} 
	public Docente(int id) {
		idDocente = id;
	}
	
	public Docente( int idDocente, String nombre, String apellido) {
		this.idDocente = idDocente; 
		this.nombre = nombre; 
		this.apellido = apellido;
	}
	
	public Docente(int idDocente, String legajo, String dni, String nombre, String apellido, LocalDate fecha_Nacimiento,
		String adress, Localidad localidad, Provincia provincia, Pais pais, String email, String telefono,
		boolean estado) {
		super();
		this.idDocente = idDocente;
		this.legajo = legajo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_Nacimiento = fecha_Nacimiento;
		this.adress = adress;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Docente [idDocente=" + idDocente + ", legajo=" + legajo + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fecha_Nacimiento=" + fecha_Nacimiento + ", adress=" + adress
				+ ", localidad=" + localidad.getIdLocalidad() + ", provincia=" + provincia.getIdProvincia() + ", pais=" + pais.getIdPais() + ", email=" + email
				+ ", telefono=" + telefono + ", estado=" + estado + "]";
	}
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}
	public void setFecha_Nacimiento(LocalDate fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public Pais getPais() {
		return pais;
	}


	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
	
}
