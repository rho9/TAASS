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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
