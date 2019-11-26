package it.rud.rudmarket.model;

import javax.persistence.*;

@Entity
public class Promozione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPromozione;

	@ManyToOne
	@JoinColumn(name = "user_email")
	User user;

	@ManyToOne
	@JoinColumn(name = "prodotto_nomeMarca")
	Prodotto prodotto;

	private int sconto;

	public Promozione(User user, Prodotto prodotto, int sconto) {
		this.user = user;
		this.prodotto = prodotto;
		this.sconto = sconto;
	}
}
