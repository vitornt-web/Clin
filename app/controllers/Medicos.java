package controllers;

import java.util.List;

import models.Medico;
import play.mvc.Controller;

public class Medicos extends Controller{
 
	public void form() {
		render();
	}
	
	public void salvar(Medico med) {
		med.save();
		form();
	}
	
	public void listar() {
		List<Medico> lista = Medico.findAll();
		render(lista);
	}
}
