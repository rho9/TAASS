package com.rud.rudmarket.model;

public class ProdottoInCarrello {
	private Prodotto prodotto;
	private int percSconto;
	private int quantita;

	public ProdottoInCarrello(Prodotto prodotto, int percSconto, int quantita) {
		this.prodotto = prodotto;
		this.percSconto = percSconto;
		this.quantita = quantita;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
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
