package it.rud.rudmarket.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Evento {

	@Id
	private String nome;
	private String descrizione;

	public Evento(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public Evento() {
		this(null, null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
