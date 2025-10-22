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
	public String senha;
	
	
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	@Enumerated(EnumType.STRING)
	public Perfil perfil;
	
	@ManyToOne
	public Especialidade especialidade;
	
	public Medico() {
		this.status = Status.ATIVO;
		this.perfil = perfil.ASSISTENTE;
	}
	
	
	public Medico(String nome, String email, Integer crm,Especialidade esp, String senha) {
		this.nome = nome;
		this.email = email;
		this.crm = crm;
		this.status = Status.ATIVO;
		this.especialidade = esp;
		this.senha = senha;
		this.perfil = perfil.ASSISTENTE;
	}

}
