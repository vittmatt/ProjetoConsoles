package br.com.API.projetoGame.consoles.repository;

import br.com.API.projetoGame.consoles.domains.JogadorDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorDomain, Long> {

    List<JogadorDomain> findByNome(String nome);
}
