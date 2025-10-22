package controllers;

import java.util.List;

import Security.Administrador;
import models.Especialidade;
import models.Medico;
import play.mvc.Controller;


public class CadastroMed extends Controller {
	
	@Administrador
	public static void form() {
		List<Especialidade> especialidades = Especialidade.findAll();
		render(especialidades);
	}
 
	@Administrador
	public static void salvar(Medico med) {

		Medico m = med;
		m.save();
		flash.success("Parabéns, você está cadastrado.");
		// listar(null);
	    Logins.form();
	}
}
