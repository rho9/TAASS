package it.rud.rudmarket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sezione {

	@Id
	private String nomeSezione;

	private String img;

	@OneToMany(targetEntity = Prodotto.class)
	@JoinColumn(name = "nomeSezione")
	private List<Prodotto> prodottoList;

	@ManyToMany(mappedBy = "catalogo")
	private List<Supermercato> supermercatoList;

	public Sezione() {
		this(null, null, null, null);
	}

	public Sezione(String nomeSezione, String img, List<Prodotto> prodottoList, List<Supermercato> supermercatoList) {
		this.nomeSezione = nomeSezione;
		this.img = img;
		this.prodottoList = prodottoList;
		this.supermercatoList = supermercatoList;
	}

	public List<Supermercato> getSupermercatoList() {
		return supermercatoList;
	}

	public void setSupermercatoList(List<Supermercato> supermercatoList) {
		this.supermercatoList = supermercatoList;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
