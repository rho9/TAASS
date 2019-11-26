package it.rud.rudmarket.model;

import it.rud.rudmarket.model.ids.ProdottoID;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prodotto {

    @EmbeddedId
    private ProdottoID idProdotto;
    private int prezzo;

    public Prodotto() {
    	this(null, null, 0);
	}

	public Prodotto(String nomeProdotto, String marcaProdotto, int prezzo) {
    	this.idProdotto = new ProdottoID(nomeProdotto, marcaProdotto);
    	this.prezzo = prezzo;
	}

	public ProdottoID getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(ProdottoID idProdotto) {
		this.idProdotto = idProdotto;
	}
}