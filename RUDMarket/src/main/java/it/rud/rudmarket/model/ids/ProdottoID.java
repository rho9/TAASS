package it.rud.rudmarket.model.ids;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProdottoID implements Serializable {

	private String nome, marca;

	public ProdottoID(String nome, String marca) {
		this.nome = nome;
		this.marca = marca;
	}
}
