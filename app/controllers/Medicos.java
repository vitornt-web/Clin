package controllers;

import java.util.List;

import Security.Administrador;
import models.Especialidade;
import models.Medico;
import models.Status;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Medicos extends Controller {

	public static void form() {
		List<Especialidade> especialidades = Especialidade.findAll();
		render(especialidades);
	}

	@Administrador
	public static void listar(String termo) {
		List<Medico> medicosAtivos = null;
		medicosAtivos = Medico.find("status <> ?1", Status.INATIVO).fetch();

		if (termo != null) {
			medicosAtivos = Medico.find("(lower(nome) like ?1 " + "or lower(email) like ?1) " + "and status <> ?2",
					"%" + termo.toLowerCase() + "%", Status.INATIVO).fetch();
		}

		render(medicosAtivos, termo);

	}

	@Administrador
	public static void editar(Long id) {

		Medico med = Medico.findById(id);
		List<Especialidade> especialidades = Especialidade.findAll();
		renderTemplate("Medicos/form.html", med, especialidades);
	}

	@Administrador
	public static void deletar(Long id) {
		Medico med = Medico.findById(id);
		med.status = Status.INATIVO;
		med.save();
		listar(null);
	}
}
