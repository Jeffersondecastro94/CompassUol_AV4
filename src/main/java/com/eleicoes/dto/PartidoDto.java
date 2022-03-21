package com.eleicoes.dto;

import java.util.Date;

import com.eleicoes.entity.PartidoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PartidoDto {
	private Integer id;
	private String nomePartido;
	private String sigla;
	private String ideologia;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFundacao;
	
	public PartidoDto() {};
	public PartidoDto(PartidoEntity obj) {
		
		id=obj.getId();
		nomePartido=obj.getNomePartido();
		sigla=obj.getSigla();
		ideologia=obj.getIdeologia();
		dataFundacao=obj.getDataFundacao();
	}

}
