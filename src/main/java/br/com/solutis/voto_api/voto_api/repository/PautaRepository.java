package br.com.solutis.voto_api.voto_api.repository;

import br.com.solutis.voto_api.voto_api.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
}
