package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import models.Especialidade;


import play.db.jpa.Model;

@Entity
public class Medico extends Model{
	
	public String nome;
	public String email;
	public Integer crm;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	@ManyToOne
	public Especialidade especialidade;
	
	
	public Medico(String nome, String email, Integer crm) {
		this.nome = nome;
		this.email = email;
		this.crm = crm;
		this.status = Status.ATIVO;
	}

}
