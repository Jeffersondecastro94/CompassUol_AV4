package com.eleicoes.dto;

import java.util.Date;

import com.eleicoes.entity.PartidoEntity;

import lombok.Data;

@Data
public class PartidoFormDto {
	private String nomePartido;
	private String sigla;
	private String ideologia;

	private Date dataFundacao;

	public PartidoFormDto() {
	};

	public PartidoFormDto(PartidoEntity obj) {
		nomePartido = obj.getNomePartido();
		sigla = obj.getSigla();
		ideologia = obj.getIdeologia();
		dataFundacao = obj.getDataFundacao();
	};
}
