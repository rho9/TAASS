package com.rud.rudmarket.model.form;

public class ScontoForm {

	private String emailUtente;
	private Long selectedProdotto;
	private String perc;

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public Long getSelectedProdotto() {
		return selectedProdotto;
	}

	public void setSelectedProdotto(Long selectedProdotto) {
		this.selectedProdotto = selectedProdotto;
	}

	public String getPerc() {
		return perc;
	}

	public void setPerc(String perc) {
		this.perc = perc;
	}
}
