package com.rud.rudmarket.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sezione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@OneToMany
	@JoinColumn(name = "sezione_id")
	List<Prodotto> prodottoList = new ArrayList<>();

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

	public List<Prodotto> getProdottoList() {
		return prodottoList;
	}

	public void setProdottoList(List<Prodotto> prodottoList) {
		this.prodottoList = prodottoList;
	}
}
