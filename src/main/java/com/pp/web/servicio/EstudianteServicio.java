package com.pp.web.servicio;

import java.util.List;

import com.pp.web.entidad.Estudiante;

public interface EstudianteServicio {
	
	public List<Estudiante> listarEstudiantes();
	
	public Estudiante guardarEstudiante(Estudiante estudiante);
	
	public Estudiante obtenerEstudiantePorId(Long id);
	
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	
	public void eliminarEstudiante(Long id);

}
