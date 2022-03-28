package br.com.projetoGame.consoles.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Jogador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(min = 1, max = 36)
    private String nome;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @OneToMany(mappedBy = "jogador")
    private final List<Nintendo> nintendo = new ArrayList<>();

    public Jogador() {}

    public Jogador(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Nintendo> getNintendo() {
        return nintendo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(id, jogador.id) && Objects.equals(nome, jogador.nome) && Objects.equals(nintendo, jogador.nintendo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nintendo);
    }
}
