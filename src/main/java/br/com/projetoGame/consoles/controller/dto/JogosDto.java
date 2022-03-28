package br.com.projetoGame.consoles.controller.dto;

import br.com.projetoGame.consoles.models.Jogos;
import br.com.projetoGame.consoles.repository.JogosRepository;

import java.time.LocalDateTime;
import java.util.List;

public class JogosDto {
    private final Long idJogos;
    private final String nome;
    private final String descricao;
    private final String genero;
    private final LocalDateTime dataDeLancamento;

    public JogosDto(Jogos jogos) {
        this.idJogos = jogos.getIdJogos();
        this.nome = jogos.getNome();
        this.descricao = jogos.getDescricao();
        this.genero = jogos.getGenero();
        this.dataDeLancamento = jogos.getDataDeLancamento();
    }

    public static List<JogosDto> converte(JogosRepository jogosRepository) {
        List<Jogos> jogos = jogosRepository.findAll();
        return jogos.stream().map(JogosDto::new).toList();
    }

    public Long getIdJogos() {
        return idJogos;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDateTime getDataDeLancamento() {
        return dataDeLancamento;
    }
}
