package com.example.rudapplication.model;

import java.io.Serializable;

public class Prodotto implements Serializable {
    private Long id;

    private String nome, marca;
    private float prezzo;
    private boolean atKg;

    public boolean isAtKg() {
        return atKg;
    }

    public void setAtKg(boolean atKg) {
        this.atKg = atKg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
