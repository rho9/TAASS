package it.rud.rudmarket.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prodotto {

    @Id
    private String nome;

    public Prodotto() {
        this(null);
    }

    public Prodotto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}