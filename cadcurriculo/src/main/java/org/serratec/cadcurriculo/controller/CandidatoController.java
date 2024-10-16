package org.serratec.cadcurriculo.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.cadcurriculo.dto.CandidatoDto;
import org.serratec.cadcurriculo.model.Escolaridade;
import org.serratec.cadcurriculo.model.VagaDesejada;
import org.serratec.cadcurriculo.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	private CandidatoService repositorio;
	
	@GetMapping
	public List<CandidatoDto> obterTodos(){
		return repositorio.obterTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CandidatoDto> obterPorId(@PathVariable Long id){
		Optional<CandidatoDto> dto = repositorio.obterPorId(id);
		if(!dto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CandidatoDto cadastrarCandidato(@RequestBody CandidatoDto dto) {
		return repositorio.savarCandidato(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCandidato(@PathVariable Long id){
		if(!repositorio.apagarCandidato(id)) {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CandidatoDto> alterarCandidato(@PathVariable Long id, @RequestBody CandidatoDto dto){
		Optional<CandidatoDto> candidatoAlterado = repositorio.alterarCandidato(id,dto);
		if(!candidatoAlterado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.ok(candidatoAlterado.get());
	}
	
	@GetMapping("/vagaDesejada/{vagaDesejada}")
	public List<CandidatoDto> obterPorVagaDesejada(@PathVariable VagaDesejada vagaDesejada){
		return repositorio.obterPorVagaDesejada(vagaDesejada);
	}
	
	@GetMapping("/escolaridade/{escolaridade}")
	public List<CandidatoDto> obterPorEscolaridade(@PathVariable Escolaridade escolaridade){
		return repositorio.obterPorEscolaridade(escolaridade);
	}

}


