package it.rud.rudmarket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sezione {

	@Id
	private String nome;

	@OneToMany(targetEntity = Prodotto.class)
	@JoinColumns({
			@JoinColumn(
					name = "nome_prodotto",
					referencedColumnName = "nome_prodotto"),
			@JoinColumn(
					name = "marca_prodotto",
					referencedColumnName = "marca_prodotto")
	})
	private List<Prodotto> prodottoList;


	public Sezione() {
		this(null, null);
	}

	public Sezione(String nome, List<Prodotto> prodottoList) {
		this.nome = nome;
		this.prodottoList = prodottoList;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List getProdottoList() {
		return prodottoList;
	}

	public void setProdottoList(List<Prodotto> prodottoList) {
		this.prodottoList = prodottoList;
	}
}
