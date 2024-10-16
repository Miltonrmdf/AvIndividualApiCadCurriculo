package org.serratec.cadcurriculo.service;

import java.util.List;
import java.util.Optional;

import org.serratec.cadcurriculo.dto.CandidatoDto;
import org.serratec.cadcurriculo.model.Candidato;
import org.serratec.cadcurriculo.model.Escolaridade;
import org.serratec.cadcurriculo.model.VagaDesejada;
import org.serratec.cadcurriculo.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository service;
	
	public List<CandidatoDto> obterTodos(){
		return service.findAll().stream().map(c-> CandidatoDto.toDto(c)).toList();
	}
	
	public Optional<CandidatoDto> obterPorId(Long id){
		if(!service.existsById(id)) {
			return Optional.empty();
		}
			return Optional.of(CandidatoDto.toDto(service.findById(id).get()));
	}
	
	public CandidatoDto savarCandidato(CandidatoDto dto) {
		Candidato candidatoEntity = service.save(dto.toEntity());
		return CandidatoDto.toDto(candidatoEntity);
	}
	
	public boolean apagarCandidato(Long id) {
		if(!service.existsById(id)) {
			return false;
		}
			service.deleteById(id);
			return true;
	}
	
	public Optional<CandidatoDto> alterarCandidato(Long id, CandidatoDto dto){
		if(!service.existsById(id)) {
			return Optional.empty();
		}
			Candidato candidatoEntity = dto.toEntity();
			candidatoEntity.setId(id);
			service.save(candidatoEntity);
			return Optional.of(CandidatoDto.toDto(candidatoEntity));
	}
	
	public List<CandidatoDto> obterPorVagaDesejada(VagaDesejada vagaDesejada){
		List<Candidato> candidato = service.findByVagaDesejada(vagaDesejada);
		return candidato.stream().map(c-> CandidatoDto.toDto(c)).toList();
	}
	
	public List<CandidatoDto> obterPorEscolaridade(Escolaridade escolaridade){
		List<Candidato> candidato = service.findByEscolaridade(escolaridade);
		return candidato.stream().map(c-> CandidatoDto.toDto(c)).toList();
	}
}
