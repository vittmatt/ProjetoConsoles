package br.com.projetoGame.consoles.repository;

import br.com.projetoGame.consoles.models.Nintendo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NintendoRepository extends JpaRepository<Nintendo, Long> {
     Optional<Nintendo> findByApelidoConsole(String nome);
}
