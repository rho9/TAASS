package it.rud.rudmarket.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sezione {

	@Id
	private String nome;

	public Sezione() {
		this(null);
	}

	public Sezione(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
