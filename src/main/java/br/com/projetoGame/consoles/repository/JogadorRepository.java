package br.com.projetoGame.consoles.repository;

import br.com.projetoGame.consoles.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    public List<Jogador> findByNome(String nome);
}
