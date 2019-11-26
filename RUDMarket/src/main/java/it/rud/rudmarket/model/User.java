package it.rud.rudmarket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

	@Id
	private String email;
	private String nome, cognome;
	private String ncarta;
	private String password;
	private String roles;

	@OneToMany(targetEntity = Promozione.class)
	@JoinColumn(name = "promozione_id")
	private List<Promozione> promozioneList;

	public User() {
		this(null, null, null, null, null, null);
	}

	public User(String email, String nome, String cognome, String ncarta, String password, String roles) {
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.ncarta = ncarta;
		this.password = password;
		this.roles = roles;
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

	public String getNcarta() {
		return ncarta;
	}

	public void setNcarta(String ncarta) {
		this.ncarta = ncarta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
}
