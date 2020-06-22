package com.algaworks.osworks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osworks.domain.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}
