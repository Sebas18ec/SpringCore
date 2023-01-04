package com.pp.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.web.entidad.Materia;
import com.pp.web.repositorio.MateriaRepositorio;


@Service
public class MateriaServicioImpl implements MateriaServicio{
	
	@Autowired
	private MateriaRepositorio repositorio;

	@Override
	public List<Materia> listarMaterias() {
		return repositorio.findAll();
	}

	@Override
	public Materia guardarMaterias(Materia materia) {
		return repositorio.save(materia);
	}

	@Override
	public Materia obtenerMateriaPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Materia actualizarMateria(Materia materia) {
		return repositorio.save(materia);
	}

	@Override
	public void eliminarMateria(Long id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Materia> findByKeyword(String keyword) {
		return repositorio.findByKeyword(keyword);
	}
	
	

}
