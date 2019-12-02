package com.rud.rudmarket.model;

import javax.persistence.*;

@Entity
public class Ordine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "prodotto_id")
	Prodotto prodotto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
