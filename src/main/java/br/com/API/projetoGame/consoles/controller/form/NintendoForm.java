package br.com.API.projetoGame.consoles.controller.form;


import br.com.API.projetoGame.consoles.domains.JogadorDomain;
import br.com.API.projetoGame.consoles.repository.JogadorRepository;
import br.com.API.projetoGame.consoles.domains.NintendoDomain;
import br.com.API.projetoGame.consoles.domains.enums.ModoDesempenho;

public class NintendoForm {
    private ModoDesempenho modoDesempenho;
    private String nomeNintendo;

    public ModoDesempenho getModoDesempenho() {
        return modoDesempenho;
    }

    public void setModoDesempenho(ModoDesempenho modoDesempenho) {
        this.modoDesempenho = modoDesempenho;
    }

    public String getNomeNintendo() {
        return nomeNintendo;
    }

    public void setNomeNintendo(String nomeNintendo) {
        this.nomeNintendo = nomeNintendo;
    }

    public NintendoDomain converte(JogadorRepository jogadorRepository, Long idJogador) {
        JogadorDomain jogador = jogadorRepository.getById(idJogador);
        return new NintendoDomain(this.nomeNintendo, this.modoDesempenho, jogador);
    }

    public NintendoDomain atualiza(NintendoDomain nintendo) {
        nintendo.setNomeNintendo(this.nomeNintendo);
        nintendo.setModoDesempenho(this.modoDesempenho);
        return nintendo;
    }
}
