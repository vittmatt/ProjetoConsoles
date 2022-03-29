package br.com.API.projetoGame.consoles.repository;

import br.com.API.projetoGame.consoles.domains.NintendoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NintendoRepository extends JpaRepository<NintendoDomain, Long> {
}
