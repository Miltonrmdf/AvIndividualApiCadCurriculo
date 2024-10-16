package org.serratec.cadcurriculo.repository;

import java.util.List;


import org.serratec.cadcurriculo.model.Candidato;
import org.serratec.cadcurriculo.model.Escolaridade;
import org.serratec.cadcurriculo.model.VagaDesejada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
	
	List<Candidato> findByVagaDesejada(VagaDesejada vagaDesejada);
	List<Candidato> findByEscolaridade(Escolaridade escolaridade);

}
