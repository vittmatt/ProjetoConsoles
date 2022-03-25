package br.com.projetoGame.consoles.controller.form;


import br.com.projetoGame.consoles.models.Jogador;
import br.com.projetoGame.consoles.models.Nintendo;
import br.com.projetoGame.consoles.models.enums.ModoDesempenho;
import br.com.projetoGame.consoles.repository.JogadorRepository;

public class NintendoForm {
    private ModoDesempenho modoDesempenho;
    private String apelidoConsole;

    public ModoDesempenho getModoDesempenho() {
        return modoDesempenho;
    }

    public void setModoDesempenho(ModoDesempenho modoDesempenho) {
        this.modoDesempenho = modoDesempenho;
    }

    public String getApelidoConsole() {
        return apelidoConsole;
    }

    public void setApelidoConsole(String apelidoConsole) {
        this.apelidoConsole = apelidoConsole;
    }

    public Nintendo converte(JogadorRepository jogadorRepository, Long idJogador) {
        Jogador jogador = jogadorRepository.getById(idJogador);
        return new Nintendo(this.apelidoConsole, this.modoDesempenho, jogador);
    }

    public Nintendo atualiza(Nintendo nintendo) {
        nintendo.setApelidoConsole(this.apelidoConsole);
        nintendo.setModoDesempenho(this.modoDesempenho);
        return nintendo;
    }
}
