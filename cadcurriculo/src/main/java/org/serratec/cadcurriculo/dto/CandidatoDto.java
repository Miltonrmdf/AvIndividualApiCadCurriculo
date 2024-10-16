package org.serratec.cadcurriculo.dto;

import org.serratec.cadcurriculo.model.Candidato;
import org.serratec.cadcurriculo.model.Escolaridade;
import org.serratec.cadcurriculo.model.StatusCurriculo;
import org.serratec.cadcurriculo.model.VagaDesejada;

public record CandidatoDto(
		Long id,
		String nome,
		int cpf,
		Escolaridade escolaridade,
		VagaDesejada vagaDesejada,
		StatusCurriculo statusCurriculo
		) {
	
	public Candidato toEntity() {
		Candidato candidato=new Candidato();
		candidato.setId(this.id);
		candidato.setNome(this.nome);
		candidato.setCpf(this.cpf);
		candidato.setEscolaridade(this.escolaridade);
		candidato.setVagaDesejada(this.vagaDesejada);
		candidato.setStatusCurriculo(this.statusCurriculo);
		return candidato;
	}

	public static CandidatoDto toDto(Candidato candidato) {
		
		return new CandidatoDto(candidato.getId(),candidato.getNome(),candidato.getCpf(),
				candidato.getEscolaridade(),candidato.getVagaDesejada(),
				candidato.getStatusCurriculo());	
	}
	
}
