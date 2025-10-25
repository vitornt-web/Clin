package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import models.Especialidade;
import play.data.validation.Email;
import play.data.validation.Max;
import play.data.validation.MaxSize;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Medico extends Model{
	
	@Required(message="nome") @MaxSize(30) 
	public String nome;
	
	@Required(message="email") @Email
	public String email;
	
	@Required(message="crm") @MinSize(6)
	public String crm;
	
	@Required(message="senha") @MinSize(6)
	public String senha;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	@Enumerated(EnumType.STRING)
	public Perfil perfil;
	
	@ManyToOne @Required(message="esp")
	public Especialidade especialidade;
	
	public Medico() {
		this.status = Status.ATIVO;
		this.perfil = perfil.ASSISTENTE;
	}
	
	
	public Medico(String nome, String email, String crm,Especialidade esp, String senha) {
		this.nome = nome;
		this.email = email;
		this.crm = crm;
		this.status = Status.ATIVO;
		this.especialidade = esp;
		this.senha = senha;
		this.perfil = perfil.ASSISTENTE;
	}

}
