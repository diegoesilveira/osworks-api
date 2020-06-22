package com.algaworks.osworks.DTO;

import javax.validation.constraints.NotBlank;

public class ComentarioInsertDTO {

	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
