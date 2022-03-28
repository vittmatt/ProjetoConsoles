package br.com.projetoGame.consoles.repository;

import br.com.projetoGame.consoles.models.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosRepository extends JpaRepository<Jogos, Long> {

}
