package br.com.API.projetoGame.consoles.domains;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class JogadorDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(min = 1, max = 36)
    private String nome;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "jogador")
    private final List<NintendoDomain> nintendo = new ArrayList<>();

    public JogadorDomain() {}

    public JogadorDomain(String nome) {
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

    public List<NintendoDomain> getNintendo() {
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
        JogadorDomain jogadorDomain = (JogadorDomain) o;
        return Objects.equals(id, jogadorDomain.id) && Objects.equals(nome, jogadorDomain.nome) && Objects.equals(nintendo, jogadorDomain.nintendo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nintendo);
    }
}
