package it.rud.rudmarket.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Promozione {

	@Id
	private int idPromozione;
	private int sconto;

	public Promozione() {
		this(-1, -1);
	}

	public Promozione(int idPromozione, int sconto) {
		this.idPromozione = idPromozione;
		this.sconto = sconto;
	}


}
