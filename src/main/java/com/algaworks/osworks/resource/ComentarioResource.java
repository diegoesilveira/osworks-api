package com.algaworks.osworks.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.osworks.DTO.ComentarioDTO;
import com.algaworks.osworks.DTO.ComentarioInsertDTO;
import com.algaworks.osworks.domain.Comentario;
import com.algaworks.osworks.service.OrdemServicoService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioResource {
	
	@Autowired
	private OrdemServicoService service;
	

	
		
	@RequestMapping(value ="/orderns-servico/{ordemServicoId}/comentarios",method = RequestMethod.POST)
	public ResponseEntity<ComentarioDTO> insert(@PathVariable Long ordemServicoId, @Valid @RequestBody ComentarioInsertDTO comentarioInsertDTO) {
		service.adicionarComentario(ordemServicoId, comentarioInsertDTO.getDescricao());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comentarioInsertDTO.getDescricao()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value = "/orderns-servico/{ordemServicoId}/comentarios",method = RequestMethod.GET)
	public ResponseEntity<Comentario> findById(@PathVariable Long ordemServicoId){
		Comentario obj = service.findByIdC(ordemServicoId);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>>findAll(){
		List<Comentario> list = service.findAllCometario();
		return ResponseEntity.ok().body(list);
		
	}
 
}
