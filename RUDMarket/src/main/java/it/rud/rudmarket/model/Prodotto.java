package it.rud.rudmarket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Prodotto {

	@Id
    private String nomeMarca;
    private int prezzo;

    @ManyToMany
	@JoinTable(
			name = "promozione",
			joinColumns = @JoinColumn(name = "prodotto_nomeMarca"),
			inverseJoinColumns = @JoinColumn(name = "user_email")
	)
	List<User> usersToPromuovere;

    @OneToMany(mappedBy = "prodotto")
	List<Promozione> promozioni;

    public Prodotto() {
    	this(null, null, 0);
	}

	public Prodotto(String nomeProdotto, String marcaProdotto, int prezzo) {
    	this.nomeMarca = nomeProdotto + "_" + marcaProdotto;
    	this.prezzo = prezzo;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getNome() {
    	return this.nomeMarca.split("_")[0];
	}

	public String getMarca() {
    	return this.nomeMarca.split("_")[1];
	}

	public List<Promozione> getPromozioni() {
		return promozioni;
	}

	public void setPromozioni(List<Promozione> promozioni) {
		this.promozioni = promozioni;
	}
}