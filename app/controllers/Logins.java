package controllers;

import models.Medico;
import play.mvc.Controller;
import play.mvc.With;


public class Logins extends Controller{
	
	public static void form() {
		render();
	}

	public static void logar(String email, String senha) {
	    Medico md = Medico.find("email = ?1 and senha = ?2", email, senha).first();

	    if (md == null) {
	        flash.error("Médico não cadastrado.");
	        Logins.form();// volta pro formulário de login
	    } else {
	        session.put("med.email", md.email);
	        session.put("med.perfil", md.perfil.name());
	        flash.success("Bem-vindo " + md.nome + ", logado com sucesso!");
	        redirect("Medicos.form"); // redireciona ao form de médicos
	    }
	}

	public static void sair() {
		session.clear();
		flash.success("Você saiu do sistema.");
		Logins.form();
	}

}
