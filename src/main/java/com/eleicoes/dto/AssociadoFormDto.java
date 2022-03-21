package com.eleicoes.dto;

import java.util.Date;

import com.eleicoes.entity.AssociadoEntity;

import lombok.Data;

@Data
public class AssociadoFormDto {
	private String nome;
	private String cargoPolitico;
	private Date dataNascimento;
	private String sexo;

	public AssociadoFormDto() {
	}

	public AssociadoFormDto(AssociadoEntity obj) {
		nome = obj.getNome();
		cargoPolitico = obj.getCargoPolitico();
		dataNascimento = obj.getDataNascimento();
		sexo = obj.getSexo();
	}
}
