package it.rud.rudmarket.model.ids;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdottoID implements Serializable {

	@Column(name = "nome_prodotto")
	private String nome;

	@Column(name = "marca_prodotto")
	private String marca;

	public ProdottoID(String nome, String marca) {
		this.nome = nome;
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProdottoID)) return false;
		ProdottoID that = (ProdottoID) o;
		return Objects.equals(getNome(), that.getNome()) &&
				Objects.equals(getMarca(), that.getMarca());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNome(), getMarca());
	}
}
