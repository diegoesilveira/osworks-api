package com.algaworks.osworks.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osworks.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNome(String nome);

	List<Cliente> findByEmailContaining(String email);
	
	public boolean existsByNome(String nome);
	
	public boolean existsByEmail(String email);

	
	Optional<Cliente> findByEmail(String email);
}
