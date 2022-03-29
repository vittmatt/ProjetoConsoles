package br.com.API.projetoGame.consoles.controller.form;

import br.com.API.projetoGame.consoles.controller.dto.JogosDto;
import br.com.API.projetoGame.consoles.domains.JogosDomain;
import br.com.API.projetoGame.consoles.domains.NintendoDomain;
import br.com.API.projetoGame.consoles.repository.NintendoRepository;

public class JogosForm {
    private String nome;
    private String descricao;
    private String genero;

    public JogosDomain converte(NintendoRepository nintendoRepository, Long idConsole) {
        NintendoDomain nintendo = nintendoRepository.getById(idConsole);
        return new JogosDomain(this.nome, this.descricao, this.genero, nintendo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public JogosDto atualiza(JogosDomain jogo) {
        jogo.setNome(this.nome);
        jogo.setDescricao(this.descricao);
        jogo.setGenero(this.genero);
        return new JogosDto(jogo);
    }
}
