package br.com.projetoGame.consoles.controller.dto;

import br.com.projetoGame.consoles.models.Jogador;
import br.com.projetoGame.consoles.models.Nintendo;

import java.util.List;
import java.util.stream.Collectors;

public class JogadorDto {
    private final Long id;
    private final String nome;
    private final List<Nintendo> nintendo;

    public JogadorDto(Jogador jogador) {
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.nintendo = jogador.getNintendo();
    }

    public static List<JogadorDto> converter(List<Jogador> jogadores) {
        return jogadores.stream().map(JogadorDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Nintendo> getNintendo() {
        return nintendo;
    }
}
