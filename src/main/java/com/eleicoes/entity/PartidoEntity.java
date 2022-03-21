package com.eleicoes.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class PartidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message="Campo Partido precisa ser preenchido!")
	private String nomePartido;
	@NotBlank(message="Campo Sigla precisa ser preenchido!")
	private String sigla;
	@NotBlank(message="Campo Ideologia precisa ser preenchido!")
	private String ideologia;
	@NotNull(message = "Campo data de fundação precisa ser preenchido!")
	private Date dataFundacao;
	@JsonIgnore
	@OneToMany(mappedBy="partido")
	private List<AssociadoEntity> associados = new ArrayList<AssociadoEntity>();
	
	
	public void removeAssociado(AssociadoEntity associado) {
		associados.remove(associado);
	}
	
	public boolean procurarAssociado(AssociadoEntity associado) {
		return associados.contains(associado);
	}
}
