package br.com.projetoGame.consoles.controller.dto;

import br.com.projetoGame.consoles.models.Jogos;
import br.com.projetoGame.consoles.models.Nintendo;
import br.com.projetoGame.consoles.models.enums.ModoDesempenho;

import java.util.ArrayList;
import java.util.List;

public class NintendoDto {
    private final ModoDesempenho modoDesempenho;
    private final String apelidoConsole;
    private final List<Jogos> jogos;
    private final Long idConsole;

    public NintendoDto(Nintendo nintendo) {
        this.idConsole = nintendo.getIdConsole();
        this.modoDesempenho = nintendo.getModoDesempenho();
        this.jogos = nintendo.getJogos();
        this.apelidoConsole = nintendo.getApelidoConsole();
    }

    public static List<NintendoDto> converte(List<Nintendo> nintendo) {
        List<NintendoDto> nintendoDto = new ArrayList<>();
        nintendo.forEach(value -> nintendoDto.add(new NintendoDto(value)));
        return nintendoDto;
    }

    public ModoDesempenho getModoDesempenho() {
        return modoDesempenho;
    }

    public List<Jogos> getJogos() {
        return jogos;
    }

    public String getApelidoConsole() {
        return apelidoConsole;
    }

    public Long getIdConsole() {
        return idConsole;
    }
}
