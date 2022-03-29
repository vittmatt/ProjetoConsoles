package br.com.API.projetoGame.consoles.controller.dto;

import br.com.API.projetoGame.consoles.domains.JogosDomain;
import br.com.API.projetoGame.consoles.domains.NintendoDomain;
import br.com.API.projetoGame.consoles.domains.enums.ModoDesempenho;

import java.util.ArrayList;
import java.util.List;

public class NintendoDto {
    private final ModoDesempenho modoDesempenho;
    private final String nomeNintendo;
    private final List<JogosDomain> jogos;
    private final Long idNintendo;

    public NintendoDto(NintendoDomain nintendo) {
        this.idNintendo = nintendo.getIdNintendo();
        this.modoDesempenho = nintendo.getModoDesempenho();
        this.jogos = nintendo.getJogos();
        this.nomeNintendo = nintendo.getNomeNintendo();
    }

    public static List<NintendoDto> converte(List<NintendoDomain> nintendo) {
        List<NintendoDto> nintendoDto = new ArrayList<>();
        nintendo.forEach(value -> nintendoDto.add(new NintendoDto(value)));
        return nintendoDto;
    }

    public ModoDesempenho getModoDesempenho() {
        return modoDesempenho;
    }

    public List<JogosDomain> getJogos() {
        return jogos;
    }

    public String getNomeNintendo() {
        return nomeNintendo;
    }

    public Long getIdNintendo() {
        return idNintendo;
    }
}
