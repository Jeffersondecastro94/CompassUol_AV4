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

import com.eleicoes.dto.PartidoDto;
import com.eleicoes.dto.PartidoFormDto;
import com.eleicoes.entity.PartidoEntity;
import com.eleicoes.services.PartidosServices;

@RestController
@RequestMapping("/partidos")
public class controllerPartido {

	@Autowired
	private PartidosServices partidosService;

	@GetMapping // SELECIONA TODOS
	// <List<AssociadoDto>> PORQUE QUERMEMOS QUE O RETORNO SEJA DTO E NAO UM ENTITY
	public ResponseEntity<List<PartidoDto>> listarTodos() {
		List<PartidoEntity> list = partidosService.ListarTodos();
		// CONVERTE DE UMA LISTAENTITY PARA UMA LISTA DTO ASSIM APLICANDO A FORMATACAO
		// DA DATA
		List<PartidoDto> listDto = list.stream().map(converteParaDto -> new PartidoDto(converteParaDto))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PartidoDto> pesquisaPorId(@PathVariable Integer id) {
		PartidoDto obj = partidosService.pesquisaPorId(id);

		return ResponseEntity.ok().body(obj);

	}
	
	//@GetMapping(value = "/partidos/{id}/associados")
	
	
	
	

	@PostMapping
	public ResponseEntity<PartidoEntity> cadastrar(@RequestBody  PartidoEntity obj) {
		obj = partidosService.cadastrar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		partidosService.deletar(id);

		return ResponseEntity.noContent().build();

	};

	// ATUALIZAR
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PartidoDto> atualizar(@PathVariable @Valid Integer id, @RequestBody PartidoFormDto form) {

		return ResponseEntity.ok().body(partidosService.updatePartido(id, form));
	}

}
