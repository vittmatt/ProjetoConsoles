package br.com.projetoGame.consoles.controller.dto;

import br.com.projetoGame.consoles.models.Jogos;

import java.time.LocalDateTime;

public class JogosDto {
    private Long id;
    private String nome;
    private String descricao;
    private String genero;
    private LocalDateTime dataDeLancamento;

    public JogosDto(Jogos jogos) {
        this.id = jogos.getId();
        this.nome = jogos.getNome();
        this.descricao = jogos.getDescricao();
        this.genero = jogos.getGenero();
        this.dataDeLancamento = jogos.getDataDeLancamento();
    }

    public Long getId() {
        return id;
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
