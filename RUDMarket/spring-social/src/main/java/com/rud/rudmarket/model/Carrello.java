package com.rud.rudmarket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrello {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(mappedBy = "carrello")
	private User user;

	@ManyToMany(mappedBy = "carrelloList")
	List<Prodotto> prodottoList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
