package br.aledguedes.marketcart.dto;

import java.io.Serializable;

import br.aledguedes.marketcart.domain.Users;

public class UsersDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private String senha;

	public UsersDTO() {
		super();
	}

	public UsersDTO(Users user) {
		super();
		this.id = user.getId();
		this.nome = user.getNome();
		this.email = user.getEmail();
		this.senha = user.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
