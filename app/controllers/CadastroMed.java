package controllers;

import java.util.List;

import Security.Administrador;
import models.Especialidade;
import models.Medico;
import play.cache.Cache;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;


public class CadastroMed extends Controller {
	
	@Administrador
	public static void form() {
		List<Especialidade> especialidades = Especialidade.findAll();
		Medico med = (Medico)Cache.get("med");
		render(especialidades, med);
	}
	
	@Administrador
	public static void salvar(@Valid Medico med) {

	    if (validation.hasErrors()) {
	        validation.keep();
	        flash.error("Erro ao salvar. Verifique os campos.");
	        form();
	    }

	    med.save();
	    flash.success("Médico cadastrado com sucesso!");
	    form();
	}

	
	 @Administrador
		public static void editar(Long id) {

			Medico med = Medico.findById(id);
			List<Especialidade> especialidades = Especialidade.findAll();
			renderTemplate("CadastroMed/form.html", med, especialidades);
		}

}
