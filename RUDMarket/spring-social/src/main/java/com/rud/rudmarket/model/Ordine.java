package com.rud.rudmarket.model;

import javax.persistence.*;

@Entity
public class Ordine {
	@Id
	@Column(name = "id", unique = true, columnDefinition="VARCHAR(64)")
	private String id;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "prodotto_id")
	Prodotto prodotto;

	private String nome, cognome, indirizzo, supermercatoId;

	public String getSupermercatoId() {
		return supermercatoId;
	}

	public void setSupermercatoId(String supermercatoId) {
		this.supermercatoId = supermercatoId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
