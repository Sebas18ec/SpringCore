package com.pp.web.controlador;

import java.util.ArrayList;
import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.pp.web.entidad.Materia;
import com.pp.web.servicio.MateriaServicio;

@Controller
public class MejorMateriaControlador {
	
	@Autowired
	private MateriaServicio servicio;
	
	
	@GetMapping({"/reporte"})
	public String listarMejorMaterias(Model modelo, String keyword) {
		
		ArrayList<Materia> materias = new ArrayList<Materia>();
		materias = (ArrayList<Materia>) servicio.listarMaterias();
		
		for(Materia materia : materias) {
			
			
			double sumaValoraciones = materia.getValoracion();
			
			double valoracionFinal = sumaValoraciones/materia.getNvaloraciones();
			
			materia.setValoracion(valoracionFinal);
			
			if(materia.getNestudiantes() <= 5)
			{
				valoracionFinal = valoracionFinal*0.9;
				
				if(materia.getNtareas()<10)
				{
					valoracionFinal = valoracionFinal*0.9;
				}
				
				materia.setValoracionFinal(valoracionFinal);
			}
			else 
			{
				if(materia.getNtareas()<10)
				{
					valoracionFinal = valoracionFinal*0.9;
				}
				
				materia.setValoracionFinal(valoracionFinal);
				
			}
				
		}
		
		materias.sort(Comparator.comparing(Materia::getValoracionFinal).reversed());
		
		if(keyword != null)
		{
			ArrayList<Materia> materiasKeyword = new ArrayList<Materia>();
			materiasKeyword = (ArrayList<Materia>) servicio.findByKeyword(keyword);
			materiasKeyword.sort(Comparator.comparing(Materia::getValoracionFinal).reversed());
			
			modelo.addAttribute("materias",materiasKeyword);
		}
		else 
		{
			
			modelo.addAttribute("materias",materias);
			
		}
		
		
		return "mejormateria";
	}
	
	
	

}
