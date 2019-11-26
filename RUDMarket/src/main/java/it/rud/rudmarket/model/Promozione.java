package it.rud.rudmarket.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Promozione {

	@Id
	private int id;
	private int sconto;

	public Promozione() {
		this(-1, -1);
	}

	public Promozione(int id, int sconto) {
		this.id = id;
		this.sconto = sconto;
	}


}
