package com.eleicoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eleicoes.entity.AssociadoEntity;

//ASSOCIADOREPOSITORY FAZ CONTATO DIRETO COM O BANCO DENTRO DELE TEMOS A CLASSE E O TIPO DA CHAVE PRIMARIA QUE TAMOS USANDO
public interface AssociadoRepository extends JpaRepository<AssociadoEntity, Integer> {
//public interface AssociadoRepository extends JpaRepository<AssociadoDto, Integer>{
	List<AssociadoEntity> findByid(Integer idAssociadoEntity);

	List<AssociadoEntity> findByCargoPolitico(String cargoPolitico);

	
}
