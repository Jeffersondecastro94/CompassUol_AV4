package com.eleicoes.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class AssociadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	@NotBlank(message = "Campo nome precisa ser preenchido!")
	private String nome;
	@NotBlank(message = "Campo cargo precisa ser preenchido!")
	private String cargoPolitico;
	@NotNull(message = "Campo data de nascimento precisa ser preenchido!")
	private Date dataNascimento;
	@NotBlank(message = "Campo sexo precisa ser preenchido!")
	private String sexo;
	@ManyToOne

	@JoinColumn(name = "partido")
	private PartidoEntity partido;
	public boolean contains(AssociadoEntity associado) {
		// TODO Auto-generated method stub
		return false;
	}
	public void remove(AssociadoEntity associado) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
