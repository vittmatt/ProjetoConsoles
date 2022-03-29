package br.com.API.projetoGame.consoles.controller.form;

import br.com.API.projetoGame.consoles.domains.JogadorDomain;
import br.com.API.projetoGame.consoles.repository.JogadorRepository;

public class JogadorForm {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public JogadorDomain converter() {
        return new JogadorDomain(this.nome);
    }

    public JogadorDomain atualizar(Long id, JogadorRepository jogadorRepository) {
        JogadorDomain jogador = jogadorRepository.getById(id);
        jogador.setNome(this.nome);
        return jogador;
    }
}
