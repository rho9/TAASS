package it.rud.rudmarket.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

	private String email, nome, cognome, ncarta, password;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(User user) {
		this.email = user.getEmail();
		this.nome = user.getNome();
		this.cognome = user.getCognome();
		this.ncarta = user.getNcarta();
		this.password = user.getPassword();

		List<GrantedAuthority> list = new ArrayList<>();
		List<String> strings = Arrays.asList(user.getRoles().split(","));

		for (String s : strings) {
			list.add(new SimpleGrantedAuthority("ROLE_" + s.toUpperCase()));
		}

		this.authorities = list;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
