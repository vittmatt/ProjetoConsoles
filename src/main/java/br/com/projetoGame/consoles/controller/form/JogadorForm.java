package br.com.projetoGame.consoles.controller.form;

import br.com.projetoGame.consoles.controller.dto.JogadorDto;
import br.com.projetoGame.consoles.models.Jogador;
import br.com.projetoGame.consoles.repository.JogadorRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class JogadorForm {

    @NotBlank @Length(max = 36)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Jogador converter() {
        return new Jogador(this.nome);
    }

    public Jogador atualizar(Long id, JogadorRepository jogadorRepository) {
        Jogador jogador = jogadorRepository.getById(id);
        jogador.setNome(this.nome);
        return jogador;
    }
}
