package com.rud.rudmarket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome, marca;
	private int prezzo;

	@OneToMany(mappedBy = "prodotto")
	List<Sconto> scontoList;

	@OneToMany(mappedBy = "prodotto")
	List<Ordine> ordineList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public List<Sconto> getScontoList() {
		return scontoList;
	}

	public void setScontoList(List<Sconto> scontoList) {
		this.scontoList = scontoList;
	}

	public List<Ordine> getOrdineList() {
		return ordineList;
	}

	public void setOrdineList(List<Ordine> ordineList) {
		this.ordineList = ordineList;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
