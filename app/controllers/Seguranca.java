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
      	   String perfil = session.get("perfilPerfil");
      	   Administrador adminAnnotation = getActionAnnotation(Administrador.class);
      	   if (adminAnnotation != null && 
      			   !Perfil.ADMINISTRADOR.name().equals(perfil)) {
              forbidden("Acesso restrito aos administradores do sistema");
      	    }
 	}

}
