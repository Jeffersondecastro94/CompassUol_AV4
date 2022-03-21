package com.eleicoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.eleicoes.entity.PartidoEntity;

public interface PartidoRepository extends JpaRepository<PartidoEntity, Integer> {
	List<PartidoEntity> findByid(Integer idPartidoEntity);
}
