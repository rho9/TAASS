package com.rud.rudmarket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supermercato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@ManyToMany
	@JoinTable(
			name = "catalogo",
			joinColumns = @JoinColumn(name = "supermercato_id"),
			inverseJoinColumns = @JoinColumn(name = "sezione_id")
	)
	List<Sezione> sezioneList;

	private float lat, lng;

	public List<Sezione> getSezioneList() {
		return sezioneList;
	}

	public void setSezioneList(List<Sezione> sezioneList) {
		this.sezioneList = sezioneList;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
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
}
