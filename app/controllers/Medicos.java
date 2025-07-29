package controllers;

import java.util.List;

import models.Medico;
import models.Status;
import play.mvc.Controller;

public class Medicos extends Controller{
 
	public static void form() {
		render();
	}
	
	public static void listar(String termo) {
	    List<Medico> medicosAtivos;

	    if (termo == null || termo.trim().isEmpty()) {
	        medicosAtivos = Medico.find(
	            "status <> ?1 or status is null",
	            Status.INATIVO
	        ).fetch();
	    } else {
	        String termoBusca = "%" + termo.toLowerCase() + "%";
	        medicosAtivos = Medico.find(
	            "lower(nome) like ?1 and (status <> ?2 or status is null)",
	            termoBusca, Status.INATIVO
	        ).fetch();
	    }

	    render(medicosAtivos, termo);
	}

	
	public static void salvar(Medico med) {
	
		med.save();
//      listar(null);		
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
	    listar(null);
	}
}
