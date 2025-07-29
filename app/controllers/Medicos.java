package controllers;

import java.util.List;

import models.Medico;
import play.mvc.Controller;

public class Medicos extends Controller{
 
	public static void form() {
		render();
	}
	public static void listar() {
		List<Medico> lista = Medico.findAll();
		render(lista);
	}
	
	public static void salvar(Medico med) {
	
		med.save();
		listar();
	}
	
	public static void editar(Long id) {
		
		Medico med = Medico.findById(id); 
		if(med == null) {
          flash.error("Médico não está inserido.");	
          renderTemplate("Medicos/listar.html");
		}
		renderTemplate("Medicos/form.html", med);
	}
	
	public static void deletar(Long id) {
		Medico med = Medico.findById(id);
		med.delete();
	    listar();
	}
}
