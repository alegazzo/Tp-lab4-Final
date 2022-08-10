package Dominio;

import java.sql.Date;
import java.time.LocalDate;

public class Alumno {
	private int idAlumno;
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
	
	public Alumno () {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", legajo=" + legajo + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fecha_Nacimiento=" + fecha_Nacimiento + ", adress=" + adress
				+ ", localidad=" + localidad.getNombre() + ", provincia=" + provincia.getNombreProvincia() + ", pais=" + pais.getNombrePais() + ", email=" + email
				+ ", telefono=" + telefono + ", estado=" + estado + "]";
	}


	public Alumno (int id) {
		idAlumno = id;
	}
	
	public Alumno(
			int idAlumno, 
			String legajo, 
			String dni, 
			String nombre, 
			String apellido, 
			LocalDate fecha_Nacimiento,
			String adress, 
			Localidad localidad, 
			Provincia provincia, 
			Pais pais, 
			String email, 
			String telefono,
			boolean estado) {
		super();
		this.idAlumno = idAlumno;
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
	
	public Alumno(int idAlumno, 
			String legajo, 
			String nombre, 
			String apellido) {
		super();
		this.idAlumno = idAlumno;
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
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
	public int getIdDocente() {
		return idAlumno;
	}
	public void setIdDocente(int idDocente) {
		this.idAlumno = idDocente;
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
	
	
}
