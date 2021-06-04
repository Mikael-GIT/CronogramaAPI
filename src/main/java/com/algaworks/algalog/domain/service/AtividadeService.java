package com.algaworks.algalog.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Atividade;
import com.algaworks.algalog.domain.repositories.AtividadeRepository;

@Service
public class AtividadeService {
	@Autowired
	private AtividadeRepository repository;
	public List<Atividade> listar(){
		return repository.findAll();
	}
	
	public Atividade salvar(Atividade atividade) {
		return repository.save(atividade);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
