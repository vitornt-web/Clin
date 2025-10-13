package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller{
	
	@Before(unless= {"Medicos.listar"})
	public static void verificar() {
		if(session.contains("med.email") == false) {
			Logins.form();
		} else {
			Medicos.form();
		}
	}

}
