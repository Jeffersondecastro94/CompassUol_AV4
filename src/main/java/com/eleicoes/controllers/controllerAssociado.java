package com.eleicoes.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eleicoes.dto.AssociadoDto;
import com.eleicoes.dto.AssociadoFormDto;
import com.eleicoes.entity.AssociadoEntity;
import com.eleicoes.services.AssociadosService;

@RestController
@RequestMapping("/associados")
public class controllerAssociado {

	@Autowired
	private AssociadosService associadosService;

	@GetMapping // SELECIONA TODOS
	public ResponseEntity<List<AssociadoDto>> listarTodos(String cargoPolitico) {
		List<AssociadoEntity> list = associadosService.ListarTodos(cargoPolitico);
		List<AssociadoDto> listDto = list.stream().map(converteParaDto -> new AssociadoDto(converteParaDto))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	// SELECIONA POR ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<AssociadoDto> pesquisaPorId(@PathVariable Integer id) {
		AssociadoDto obj = associadosService.pesquisaPorId(id);
		return ResponseEntity.ok().body(obj);

	}

//CADASTRAR
	@PostMapping
	@Transactional
	public ResponseEntity<AssociadoEntity> cadastrar(@RequestBody @Valid AssociadoEntity obj) {
		obj = associadosService.cadastrar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

//DELETAR
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		associadosService.deletar(id);
		return ResponseEntity.noContent().build();

	};
	
	@DeleteMapping("/{idAssociado}/partidos/{idPartido}")
	@Transactional
	public ResponseEntity<?> deleteAssociado(@PathVariable Integer idAssociado, @PathVariable Integer idPartido){
		associadosService.deletarAssociacao(idAssociado, idPartido);
		return ResponseEntity.noContent().build();
	}

	// ATUALIZAR
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AssociadoDto> atualizar(@PathVariable @Valid Integer id, @RequestBody AssociadoFormDto form) {
		return ResponseEntity.ok().body(associadosService.updateAssociado(id, form));
	}

}
