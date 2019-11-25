package it.rud.rudmarket.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Sezione {

	@Id
	private String nome;

	@OneToMany(targetEntity = Prodotto.class)
	@JoinColumn(name = "sezione_name")
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
