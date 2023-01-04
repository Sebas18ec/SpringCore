package com.pp.web.servicio;

import java.util.List;

import com.pp.web.entidad.Materia;

public interface MateriaServicio {
	
	public List<Materia> listarMaterias();
	
	public Materia guardarMaterias(Materia materia);
	
	public Materia obtenerMateriaPorId(Long id);
	
	public Materia actualizarMateria(Materia materia);
	
	public void eliminarMateria(Long id);
	
	public List<Materia> findByKeyword(String keyword);

}
