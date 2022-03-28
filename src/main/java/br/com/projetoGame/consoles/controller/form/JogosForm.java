package br.com.projetoGame.consoles.controller.form;

import br.com.projetoGame.consoles.controller.dto.JogosDto;
import br.com.projetoGame.consoles.models.Jogos;
import br.com.projetoGame.consoles.models.Nintendo;
import br.com.projetoGame.consoles.repository.NintendoRepository;

public class JogosForm {
    private String nome;
    private String descricao;
    private String genero;

    public Jogos converte(NintendoRepository nintendoRepository, Long idConsole) {
        Nintendo nintendo = nintendoRepository.getById(idConsole);
        return new Jogos(this.nome, this.descricao, this.genero, nintendo);
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

    public JogosDto atualiza(Jogos jogo) {
        jogo.setNome(this.nome);
        jogo.setDescricao(this.descricao);
        jogo.setGenero(this.genero);
        return new JogosDto(jogo);
    }
}
