package br.com.projetoGame.consoles.repository;

import br.com.projetoGame.consoles.models.Nintendo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NintendoRepository extends JpaRepository<Nintendo, Long> {
}
