package com.rud.rudmarket.model;

import javax.persistence.*;

@Entity
public class Sconto {
	@Id
	@Column(name = "id", unique = true, columnDefinition="VARCHAR(64)")
	private String id;

	private int perc;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "prodotto_id")
	Prodotto prodotto;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPerc() {
		return perc;
	}

	public void setPerc(int perc) {
		this.perc = perc;
	}
}
