package br.com.API.projetoGame.consoles.repository;

import br.com.API.projetoGame.consoles.domains.JogosDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogosRepository extends JpaRepository<JogosDomain, Long> {

}
