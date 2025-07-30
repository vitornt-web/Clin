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
	
	public static void listar(String termo) {
	    List<Medico> medicosAtivos = null;
	    medicosAtivos = Medico.find("status <> ?1", Status.INATIVO).fetch();
	    
	    if(termo == null) {
	    	medicosAtivos = Medico.findAll();
	    }else {
	    	medicosAtivos = Medico.find("lower(nome) like ?1 "
					+ "or lower(email) like ?1",
					"%" + termo.toLowerCase() + "%").fetch();
	    }
			render(medicosAtivos, termo);
	    
	}

	
	public static void salvar(Medico med) {
	
		Medico m =med;
		m.save();	
		form();
	}
	
	public static void editar(Long id) {
		
		Medico med = Medico.findById(id); 
		List<Especialidade> especialidades = Especialidade.findAll();
		renderTemplate("Medicos/form.html", med);
	}
	
	public static void deletar(Long id) {
		Medico med = Medico.findById(id);
		med.status = Status.INATIVO;
		med.save();
	    listar(null);
	}
}
