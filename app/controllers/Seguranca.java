package controllers;

import Security.Administrador;
import models.Perfil;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {

	@Before(unless = { "Logins.form" })
	static void verificar() {
		if (session.get("med.email") == null) {
			Logins.form();
		}
	}

	@Before
	static void verificarAdministrador() {
		System.out.println("--- DEBUG: Verificando permissão de Admin ---");

		// Esta é a linha que corrigimos (de "perfilPerfil" para "med.perfil")
		String perfil = session.get("med.perfil");

		System.out.println("--- DEBUG: Perfil lido da sessão (med.perfil): [" + perfil + "] ---");

		Administrador adminAnnotation = getActionAnnotation(Administrador.class);

		if (adminAnnotation != null) {
			System.out.println("--- DEBUG: Acesso à página precisa de ADMIN. Verificando...");
			if (!Perfil.ADMINISTRADOR.name().equals(perfil)) {
				System.out.println("--- DEBUG: FALHA! O perfil não é ADMINISTRADOR. Bloqueando acesso. ---");
				forbidden("Acesso restrito aos administradores do sistema");
			} else {
				System.out.println("--- DEBUG: SUCESSO! O perfil é ADMINISTRADOR. Acesso permitido. ---");
			}
		}
	}
}
