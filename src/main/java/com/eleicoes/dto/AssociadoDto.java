package com.eleicoes.dto;

import java.util.Date;

import com.eleicoes.entity.AssociadoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AssociadoDto {
	
	public AssociadoDto() {
	};
	private Integer id;
	private String nome;
	private String cargoPolitico;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	private String sexo;
	
	public AssociadoDto(AssociadoEntity obj) {
		id = obj.getId();
		nome = obj.getNome();
		cargoPolitico = obj.getCargoPolitico();
		dataNascimento = obj.getDataNascimento();
		sexo = obj.getSexo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargoPolitico() {
		return cargoPolitico;
	}

	public void setCargoPolitico(String cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




}
