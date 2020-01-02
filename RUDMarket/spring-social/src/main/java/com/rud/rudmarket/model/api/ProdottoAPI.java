package com.rud.rudmarket.model.api;

import com.rud.rudmarket.model.Prodotto;

import java.io.Serializable;

public class ProdottoAPI implements Serializable {

	private String nome, marca;
	private float prezzo;
	private boolean atKg;

	public ProdottoAPI(Prodotto p) {
		this.nome = p.getNome();
		this.marca = p.getMarca();
		this.prezzo = p.getPrezzo();
		this.atKg = p.isAtKg();
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public boolean isAtKg() {
		return atKg;
	}
}
