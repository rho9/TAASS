package com.rud.rudmarket.model.form;

import java.io.File;

public class ProdottoForm {
    private String nome, marca, prezzo;
    private Long selectedSezione;
    private String atKg;
    private File selectedFile;

    public File getSelectedFile() {
        return selectedFile;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public String getAtKg() {
        return atKg;
    }

    public void setAtKg(String atKg) {
        this.atKg = atKg;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public Long getSelectedSezione() {
        return selectedSezione;
    }

    public void setSelectedSezione(Long selectedSezione) {
        this.selectedSezione = selectedSezione;
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

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
