package com.algaworks.osworks.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdemServicoInsertDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@Valid
	@NotNull
	private ClienteIdInsert cliente;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public ClienteIdInsert getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdInsert cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	

}
