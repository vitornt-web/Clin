package controllers;

import models.Medico;
import models.Perfil;
import play.mvc.Controller;

public class Logins extends Controller {

	public static void form() {
		render();
	}

	public static void teste() {
		if (Medico.count("email = ?1", "admin@admin.com") == 0) {
			Medico admin = new Medico();
			admin.nome = "Administrador";
			admin.email = "admin@admin.com";
			admin.senha = "123";
			admin.perfil = Perfil.ADMINISTRADOR;
			admin.save();
			flash.success("Médico administrador criado com sucesso!");
		} else {
			flash.error("Administrador já existe.");
		}
		form();
	}

	public static void logar(String email, String senha) {
		Medico md = Medico.find("email = ?1 and senha = ?2", email, senha).first();

		if (md == null) {
			flash.error("E-mail ou senha incorretos.");
			form();
		} else {
			session.put("med.email", md.email);
			session.put("med.perfil", md.perfil.name());
			flash.success("Bem-vindo " + md.nome + "!");
			redirect("Application.index");
		}
	}

	public static void sair() {
		session.clear();
		flash.success("Você saiu do sistema.");
		form();
	}
}
