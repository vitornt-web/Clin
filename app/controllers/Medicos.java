package controllers;

import java.util.List;

import models.Especialidade;
import models.Medico;
import models.Status;
import play.mvc.Controller;

public class Medicos extends Controller{
 
	public static void form() {
		List<Especialidade> especialidades = Especialidade.findAll();
		
		render(especialidades);
	}
	
	public static void listar() {
	    List<Medico> medicosAtivos;
	    medicosAtivos = Medico.find("status <> ?1", Status.INATIVO).fetch();
	    

	    render(medicosAtivos);
	}

	
	public static void salvar(Medico med) {
	
		Medico m =med;
		m.save();
	
		form();
	}
	
	public static void editar(Long id) {
		
		Medico med = Medico.findById(id); 
		renderTemplate("Medicos/form.html", med);
	}
	
	public static void deletar(Long id) {
		Medico med = Medico.findById(id);
		med.status = Status.INATIVO;
		med.save();
	    listar();
	}
}
