package com.algaworks.osworks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osworks.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNome(String nome);

	List<Cliente> findByEmailContaining(String email);
	
	public boolean existsByNome(String nome);
	
		Cliente findByEmail(String email);


}
