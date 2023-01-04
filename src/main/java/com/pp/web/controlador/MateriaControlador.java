package com.pp.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pp.web.entidad.Materia;
import com.pp.web.servicio.MateriaServicio;

@Controller
public class MateriaControlador {
	
	@Autowired
	private MateriaServicio servicio;
	
	double nuevaValoracion = 0;
	
	
	@GetMapping({"/materias"})
	public String listarMateria(Model modelo) {
		modelo.addAttribute("materias",servicio.listarMaterias());
		return "materias";
	}
	
	@GetMapping("/materias/nuevo")
	public String crearMateriaFormulario(Model modelo) {	
		Materia materia = new Materia();
		modelo.addAttribute("materia",materia);
		return "crear_materia";
	}
	
	
	@PostMapping("/materias")
	public String guardarMateria(@ModelAttribute("materia")Materia materia) {
		servicio.guardarMaterias(materia);
		return "redirect:/materias";
	}
	
	
	@GetMapping("/materias/editar/{id}")
	public String editarMateriasFormulario(@PathVariable Long id, Model modelo)
	{
		modelo.addAttribute("materia",servicio.obtenerMateriaPorId(id));
		return "editar_materia";
	}
	
	
	
	@PostMapping("/materias/{id}")
	public String actualizarMateria(@PathVariable Long id, @ModelAttribute("materia")Materia materia, Model modelo ) {
		
		Materia materiaExistente = servicio.obtenerMateriaPorId(id);
		
		materiaExistente.setId(id);
		materiaExistente.setNombre(materia.getNombre());
		materiaExistente.setFacultad(materia.getFacultad());
		materiaExistente.setNestudiantes(materia.getNestudiantes());
		materiaExistente.setFechaInicioMateria(materia.getFechaInicioMateria());
		materiaExistente.setFechaFinMateria(materia.getFechaFinMateria());
		materiaExistente.setNtareas(materia.getNtareas());
		
		servicio.actualizarMateria(materiaExistente);
		
		return "redirect:/materias";
		
	}
	
	@GetMapping("/materias/eliminar/{id}")
	public String eliminarMateria(@PathVariable Long id) {
		servicio.eliminarMateria(id);
		return "redirect:/materias";
	}
	
	
	
	@GetMapping("/materias/valorar/{id}")
	public String valorarMateriasFormulario(@PathVariable Long id, Model modelo)
	{
		nuevaValoracion = servicio.obtenerMateriaPorId(id).getValoracion();
		modelo.addAttribute("materia",servicio.obtenerMateriaPorId(id));
		return "valorar_materia";
	}
	
	@PostMapping("/materias/valorar/{id}")
	public String actualizarValoracionMateria(@PathVariable Long id, @ModelAttribute("materia")Materia materia, Model modelo ) {
		
		Materia materiaExistente = servicio.obtenerMateriaPorId(id);
		materiaExistente.setNvaloraciones(materiaExistente.getNvaloraciones()+1);
		materiaExistente.setValoracion(materia.getValoracion()+nuevaValoracion);
		servicio.actualizarMateria(materiaExistente);
		
		return "redirect:/materias";
		
	}

}
