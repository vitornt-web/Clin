package controllers;

import models.Medico;
import play.mvc.Controller;

public class Logins extends Controller{
	
	public static void form() {
		render();
	}
     
	public static void teste() {
		Medico d = new Medico();
		d.nome = "admin";
		d.email = "admin@admin.com";
		d.save();
		
		form();
		
	}
	
	public static void logar(String nome, String email) {
	 
		Medico md = Medico.find("nome = ?1 and email = ?2", nome.toLowerCase(), email.toLowerCase()).first();
		
		if(md == null) {
			flash.error("Médico não cadastrado.");
			form();
			
		} else {
			session.put("med.nome", md.nome);
			session.put("med.email", md.email);
			flash.success("Bem-vindo "+md.nome+", logado com sucesso!");
			 redirect("/medicos/form"); // chama o form de médicos
		}
		
	}
	public static void sair() {
		session.clear();
		Logins.form();
	}

}
