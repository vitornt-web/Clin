package models;

import play.db.jpa.Model;

public class Medico extends Model{
	
	public String nome;
	public String email;
	public Integer crm;
	
	public Medico(String nome, String email, Integer crm) {
		this.nome = nome;
		this.email = email;
		this.crm = crm;
	}

}
