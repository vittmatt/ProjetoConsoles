package br.com.projetoGame.consoles.controller.dto;

import br.com.projetoGame.consoles.models.Jogador;
import br.com.projetoGame.consoles.models.Jogos;
import br.com.projetoGame.consoles.models.Nintendo;
import br.com.projetoGame.consoles.models.enums.ModoDesempenho;

import java.util.List;

public class NintendoDto {
    private Long id;
    private ModoDesempenho modoDesempenho;
    private List<Jogos> jogos;

    public NintendoDto(Nintendo nintendo) {
        this.id = nintendo.getId();
        this.modoDesempenho = nintendo.getModoDesempenho();
        this.jogos = nintendo.getJogos();
    }

    public Long getId() {
        return id;
    }

    public ModoDesempenho getModoDesempenho() {
        return modoDesempenho;
    }

    public List<Jogos> getJogos() {
        return jogos;
    }
}
