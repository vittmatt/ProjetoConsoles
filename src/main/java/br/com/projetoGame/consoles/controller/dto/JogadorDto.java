package br.com.projetoGame.consoles.controller.dto;

import br.com.projetoGame.consoles.models.Jogador;
import br.com.projetoGame.consoles.models.Nintendo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JogadorDto {
    private final Long id;
    private final String nome;
    private LocalDateTime dataCriacao;
    private List<NintendoDto> nintendo = new ArrayList<>();

    public JogadorDto(Jogador jogador) {
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.dataCriacao = jogador.getDataCriacao();
        this.nintendo.addAll(jogador.getNintendo().stream().map(NintendoDto::new).toList());
    }

    public static List<JogadorDto> converter(List<Jogador> jogadores) {
        return jogadores.stream().map(JogadorDto::new).toList();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<NintendoDto> getNintendo() {
        return nintendo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
