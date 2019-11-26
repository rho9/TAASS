package it.rud.rudmarket.model;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;

@Entity
public class Supermercato {

	@Id
	private String via;

	private String ntel;

	@ManyToMany
	@JoinTable(
			name = "catalogo",
			joinColumns = @JoinColumn(name = "supermercato"),
			inverseJoinColumns = @JoinColumn(name = "sezione")
	)
	private List<Sezione> catalogo;

	@OneToMany
	@JoinColumn(name = "supermercato")
	private List<Evento> eventoList;

	public Supermercato(String via, String ntel, List<Sezione> catalogo, List<Evento> eventoList) {
		this.via = via;
		this.ntel = ntel;
		this.catalogo = catalogo;
		this.eventoList = eventoList;
	}

	public Supermercato() {
		this(null, null, null, null);
	}

	public List<Sezione> getCatalogo() {
		return catalogo;
	}

	public List<Evento> getEventoList() {
		return eventoList;
	}

	public void setEventoList(List<Evento> eventoList) {
		this.eventoList = eventoList;
	}

	public void setCatalogo(List<Sezione> catalogo) {
		this.catalogo = catalogo;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNtel() {
		return ntel;
	}

	public void setNtel(String ntel) {
		this.ntel = ntel;
	}
}
