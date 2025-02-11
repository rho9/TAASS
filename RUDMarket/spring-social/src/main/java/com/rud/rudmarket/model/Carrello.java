package com.rud.rudmarket.model;

import javax.persistence.*;

@Entity
public class Carrello {

	@Id
	@Column(name = "id", unique = true, columnDefinition="VARCHAR(64)")
	private String id;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "prodotto_id")
	Prodotto prodotto;

	private float quantita;

	public float getQuantita() {
		return quantita;
	}

	public void setQuantita(float quantita) {
		this.quantita = quantita;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
