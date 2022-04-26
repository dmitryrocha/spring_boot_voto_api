package br.com.solutis.voto_api.voto_api.repository;

import br.com.solutis.voto_api.voto_api.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
}
