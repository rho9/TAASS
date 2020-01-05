package com.rud.rudmarket.model;

public class ProdottoInCarrello {
	private Prodotto prodotto;
	private int percSconto;
	private float quantita;

	public ProdottoInCarrello(Prodotto prodotto, int percSconto, float quantita) {
		this.prodotto = prodotto;
		this.percSconto = percSconto;
		this.quantita = quantita;
	}

	public float getQuantita() {
		return quantita;
	}

	public void setQuantita(float quantita) {
		this.quantita = quantita;
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
