package com.rud.rudmarket.model.form;

public class OrdineForm {

	private boolean indirizzoChecked, supermercatoChecked;
	private String selectedSupermercato;
	private String nome, cognome, indirizzo;

	public boolean isIndirizzoChecked() {
		return indirizzoChecked;
	}

	public void setIndirizzoChecked(boolean indirizzoChecked) {
		this.indirizzoChecked = indirizzoChecked;
	}

	public boolean isSupermercatoChecked() {
		return supermercatoChecked;
	}

	public void setSupermercatoChecked(boolean supermercatoChecked) {
		this.supermercatoChecked = supermercatoChecked;
	}

	public String getSelectedSupermercato() {
		return selectedSupermercato;
	}

	public void setSelectedSupermercato(String selectedSupermercato) {
		this.selectedSupermercato = selectedSupermercato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
}
