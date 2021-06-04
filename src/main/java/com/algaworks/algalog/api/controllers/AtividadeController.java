package com.algaworks.algalog.api.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Atividade;
import com.algaworks.algalog.domain.repositories.AtividadeRepository;
import com.algaworks.algalog.domain.service.AtividadeService;

@RestController
public class AtividadeController {
	
	@Autowired
	private AtividadeService atividadeService;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@GetMapping("/atividades")
	public List<Atividade> listar(){
		return atividadeService.listar();
	}
	
	@GetMapping("/atividades/{id}")
	public ResponseEntity<Atividade> BuscarPorId(@PathVariable Long id) {
		Optional<Atividade> atividade = atividadeRepository.findById(id);
		if(atividade.isPresent()) {
			return ResponseEntity.ok(atividade.get()); //Retornando status 200 caso tenha algo dentro do retorno do cliente
		}
			return ResponseEntity.notFound().build(); //Retornando status 404
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Atividade salvar(@RequestBody Atividade atividade) {
		return atividadeService.salvar(atividade);
	}
	
	@PutMapping
	public ResponseEntity<Atividade> atualizarAtividade(@PathVariable Long id, @RequestBody Atividade atividade) {
		if(!atividadeRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		atividade = atividadeService.salvar(atividade);
		return ResponseEntity.ok(atividade);
	}
	
	@DeleteMapping("/atividades/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if(!atividadeRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} 
			atividadeService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
}
