package com.algaworks.osworks.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.Cliente;
import com.algaworks.osworks.domain.OrdemServico;
import com.algaworks.osworks.domain.StatusOrdemServico;
import com.algaworks.osworks.repositories.ClienteRepository;
import com.algaworks.osworks.repositories.OrdemServicoRepository;
import com.algaworks.osworks.service.exception.ObjectNotFoundException;



@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		
		return repository.save(ordemServico);
	}
	
	public List<OrdemServico> findAll(){
		return repository.findAll();
		
	}
	
	
	public OrdemServico findById(Long id) {
		Optional<OrdemServico> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Ordem de Serviço não encontrada! " + id));
	}
}
