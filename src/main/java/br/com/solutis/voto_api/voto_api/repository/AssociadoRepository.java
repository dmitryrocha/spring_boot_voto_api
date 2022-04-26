package br.com.solutis.voto_api.voto_api.repository;

import br.com.solutis.voto_api.voto_api.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
}
