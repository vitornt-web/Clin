package controllers;

import Security.Administrador;
import models.Perfil;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {

	// Bloqueia acesso a páginas sem login
	@Before(unless = { "Logins.form", "Logins.logar", "Application.index" })
	static void verificarLogin() {
		if (session.get("med.email") == null) {
			flash.error("É necessário estar logado para acessar esta página.");
			Logins.form();
		}
	}

	// Verifica se o usuário é administrador antes de acessar métodos anotados
	@Before
	static void verificarAdministrador() {
		Administrador adminAnnotation = getActionAnnotation(Administrador.class);
		if (adminAnnotation != null) {
			String perfil = session.get("med.perfil");
			if (perfil == null || !perfil.equals(Perfil.ADMINISTRADOR.name())) {
				forbidden("Acesso restrito aos administradores do sistema.");
			}
		}
	}
}
