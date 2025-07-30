package models;

import javax.persistence.Entity;

import play.db.jpa.Model;


@Entity
public class Especialidade extends Model {
	
	public String nome;

	public Especialidade(String nome) {
		super();
		this.nome = nome;
	}
	

}
