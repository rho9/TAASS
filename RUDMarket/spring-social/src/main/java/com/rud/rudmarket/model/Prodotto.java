package com.rud.rudmarket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome, marca;

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

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
