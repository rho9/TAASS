package com.rud.rudmarket.model;

public class ProdottoInCarrello {
	private Prodotto prodotto;
	private int percSconto;

	public ProdottoInCarrello(Prodotto prodotto, int percSconto) {
		this.prodotto = prodotto;
		this.percSconto = percSconto;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public int getPercSconto() {
		return percSconto;
	}

	public void setPercSconto(int percSconto) {
		this.percSconto = percSconto;
	}
}
