package com.estudandoemcasa.cursomg.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.estudandoemcasa.cursomg.domain.Cliente;
import com.estudandoemcasa.cursomg.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Prenchimento Obrigatório")
	@Length(min = 5, max = 120, message = "O Nome deve possuir de 5 á 120 caractéres")
	private String nome;
	
	@NotEmpty(message = "Prenchimento Obrigatório")
	@Email(message = "E-mail inválido")
	private String email;
	
	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
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
	

}
