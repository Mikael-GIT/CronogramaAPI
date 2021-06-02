package com.algaworks.algalog.domain.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //Adiciona Getters, Setters, HashAndCode e ToString
@AllArgsConstructor // Cria um construtor com todos os parâmetros
@Entity
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private TipoAtividade tipoAtividade;
	@Enumerated(EnumType.STRING)
	private StatusAtividade status;
	private Date dataPostagem;
	private LocalDate dataAtual;
	private Date dataEntrega;
	@OneToOne
	private Professor professor;
	
}
