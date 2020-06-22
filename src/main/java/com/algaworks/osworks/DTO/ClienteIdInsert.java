package com.algaworks.osworks.DTO;

import javax.validation.constraints.NotNull;

public class ClienteIdInsert {
	
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
