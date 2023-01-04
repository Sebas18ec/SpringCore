package com.pp.web.entidad;


import java.sql.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Materia{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "nombre",nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "facultad",nullable = false, length = 50)
	private String facultad;
	
	@Column(name = "fechaInicioMateria",nullable = false)
	private Date fechaInicioMateria;
	
	@Column(name = "fechaFinMateria",nullable = false)
	private Date fechaFinMateria;
	
	@Column(name = "valoracion")
	private double valoracion;
	
	@Column(name = "valoracionFinal")
	private double valoracionFinal;
	
	@Column(name = "nestudiantes",nullable = false)
	private int nestudiantes;
	
	@Column(name = "nvaloraciones")
	private int nvaloraciones;
	
	@Column(name = "ntareas")
	private int ntareas;
	
	

	@OneToMany(mappedBy="materia")
    private Set<Estudiante> estudiantes;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public int getNestudiantes() {
		return nestudiantes;
	}

	public void setNestudiantes(int nestudiantes) {
		this.nestudiantes = nestudiantes;
	}

	public Date getFechaInicioMateria() {
		return fechaInicioMateria;
	}

	public void setFechaInicioMateria(Date fechaInicioMateria) {
		this.fechaInicioMateria = fechaInicioMateria;
	}

	public Date getFechaFinMateria() {
		return fechaFinMateria;
	}

	public void setFechaFinMateria(Date fechaFinMateria) {
		this.fechaFinMateria = fechaFinMateria;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public double getValoracionFinal() {
		return valoracionFinal;
	}

	public void setValoracionFinal(double valoracionFinal) {
		this.valoracionFinal = valoracionFinal;
	}

	public int getNvaloraciones() {
		return nvaloraciones;
	}

	public void setNvaloraciones(int nvaloraciones) {
		this.nvaloraciones = nvaloraciones;
	}

	public int getNtareas() {
		return ntareas;
	}

	public void setNtareas(int ntareas) {
		this.ntareas = ntareas;
	}

	
	
	
	
}
