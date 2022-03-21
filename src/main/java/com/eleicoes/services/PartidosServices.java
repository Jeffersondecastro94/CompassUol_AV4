package com.eleicoes.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleicoes.dto.PartidoDto;
import com.eleicoes.dto.PartidoFormDto;
import com.eleicoes.entity.AssociadoEntity;
import com.eleicoes.entity.PartidoEntity;
import com.eleicoes.repository.AssociadoRepository;
import com.eleicoes.repository.PartidoRepository;

@Service
public class PartidosServices {
	@Autowired
	private PartidoRepository partidoRepository;
	@Autowired
	private AssociadoRepository associadoRepository;
	@Autowired
	private ModelMapper mapper;

	
	
	// LISTAR TODOS OS DADOS DA TABELA PARTIDO
	public List<PartidoEntity> ListarTodos() {
		return partidoRepository.findAll();
	}

	// PESQUISA DADOS DA TABELA PARTIDO POR UM ID
	public PartidoDto pesquisaPorId(Integer id) {
		Optional<PartidoEntity> obj = partidoRepository.findById(id);
		// return obj.get();

		// FAZENDO AQUI DENTRO A CONVERSAO DE ENTITY PARA DTO
		return mapper.map(partidoRepository.save(obj.get()), PartidoDto.class);
	}

	// CADASTRAR NA TABELA PARTIDOS
	public PartidoEntity cadastrar(@Valid PartidoEntity obj) {
		return partidoRepository.save(obj);

	}


	public void deletar(Integer id) {
		partidoRepository.deleteById(id);

	}

	// ATUALIZAR TABELA PARTIDO
	public PartidoDto updatePartido(@Valid Integer id, PartidoFormDto body) {
		Optional<PartidoEntity> partido = partidoRepository.findById(id);
		partido.get().setNomePartido(body.getNomePartido());
		partido.get().setSigla(body.getSigla());
		partido.get().setIdeologia(body.getIdeologia());
		partido.get().setDataFundacao(body.getDataFundacao());
		return mapper.map(partidoRepository.save(partido.get()), PartidoDto.class);

	}

}
