package com.eleicoes.pacoteDeTestes;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.eleicoes.services.AssociadosService;

	
public class AssociadoServiceTeste {
	
	private AssociadosService associadoService;

    
	
	@Test
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		AssociadosService serviceAssociado=Mockito.mock(AssociadosService.class);
		serviceAssociado.deletar(id);
		return ResponseEntity.noContent().build();

	};
	
	
}
