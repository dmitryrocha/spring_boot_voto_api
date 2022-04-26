package br.com.solutis.voto_api.voto_api.repository;

import br.com.solutis.voto_api.voto_api.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
