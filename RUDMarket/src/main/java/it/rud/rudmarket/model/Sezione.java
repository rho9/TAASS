package it.rud.rudmarket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sezione {

	@Id
	private String nomeSezione;

	@OneToMany(targetEntity = Prodotto.class)
	private List<Prodotto> prodottoList;

	public Sezione() {
		this(null, null);
	}

	public Sezione(String nomeSezione, List<Prodotto> prodottoList) {
		this.nomeSezione = nomeSezione;
		this.prodottoList = prodottoList;
	}

	public String getNomeSezione() {
		return nomeSezione;
	}

	public void setNomeSezione(String nomeSezione) {
		this.nomeSezione = nomeSezione;
	}

	public List getProdottoList() {
		return prodottoList;
	}

	public void setProdottoList(List<Prodotto> prodottoList) {
		this.prodottoList = prodottoList;
	}
}
