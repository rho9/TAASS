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
	private boolean atKg;

	@ManyToMany
	@JoinTable(
			name = "Carrello",
			joinColumns = @JoinColumn(name = "prodotto_id"),
			inverseJoinColumns = @JoinColumn(name = "utente_id")
	)
	List<User> carrelloUtenti;

	@OneToMany(mappedBy = "prodotto")
	List<Ordine> ordineList;

	public List<User> getCarrelloUtenti() {
		return carrelloUtenti;
	}

	public void setCarrelloUtenti(List<User> carrelloUtenti) {
		this.carrelloUtenti = carrelloUtenti;
	}

	public boolean isAtKg() {
		return atKg;
	}

	public void setAtKg(boolean atKg) {
		this.atKg = atKg;
	}

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
