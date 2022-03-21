package com.eleicoes.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleicoes.dto.AssociadoDto;
import com.eleicoes.dto.AssociadoFormDto;
import com.eleicoes.entity.AssociadoEntity;
import com.eleicoes.entity.PartidoEntity;
import com.eleicoes.repository.AssociadoRepository;
import com.eleicoes.repository.PartidoRepository;



@Service
public class AssociadosService {
	@Autowired
	private AssociadoRepository associadoRepository;
	@Autowired
	private PartidoRepository partidoRepository;
	@Autowired
	private ModelMapper mapper;
/*
 * 
	public List<AssociadoEntity> ListarTodos() {
		return associadoRepository.findAll();
	}
  */
 //LISTA TODOS E POR CARGO POLITICO
	public List<AssociadoEntity> ListarTodos(String cargoPolitico) {
		if (cargoPolitico == null) {
			List<AssociadoEntity> listaTodos= associadoRepository.findAll();
		 return listaTodos;
	}else {
		List<AssociadoEntity> listaPorCargoPolitico = associadoRepository.findByCargoPolitico(cargoPolitico);//
		return listaPorCargoPolitico;
		
	}
	}
		
		
		
//public AssociadoEntity pesquisaPorId(Integer id) {
	public AssociadoDto pesquisaPorId(Integer id) {
		Optional<AssociadoEntity> obj = associadoRepository.findById(id);
		//return obj.get();
		
		//FAZENDO AQUI DENTRO A CONVERSAO DE ENTITY PARA DTO
		return mapper.map(associadoRepository.save(obj.get()), AssociadoDto.class);
	}
	
	public AssociadoEntity cadastrar(@Valid AssociadoEntity obj) {
		return associadoRepository.save(obj);

	}

	public void deletar(Integer id) {
		associadoRepository.deleteById(id);

	}
	
	
	public void deletarAssociacao(Integer idAssociado, Integer idPartido) {
		AssociadoEntity associado = associadoRepository.getById(idPartido);
			
		PartidoEntity partido = partidoRepository.getById(idPartido);
				
		if (partido.procurarAssociado(associado)) {
			partido.removeAssociado(associado);
		
	}
	}
/////////////////////////////////////////////////////////////////
	public AssociadoDto updateAssociado(@Valid Integer id, AssociadoFormDto body) {
		Optional<AssociadoEntity> associado = associadoRepository.findById(id);
		associado.get().setNome(body.getNome());
		associado.get().setCargoPolitico(body.getCargoPolitico());
		associado.get().setDataNascimento(body.getDataNascimento());
		associado.get().setSexo(body.getSexo());
		return mapper.map(associadoRepository.save(associado.get()), AssociadoDto.class);

	}

}
