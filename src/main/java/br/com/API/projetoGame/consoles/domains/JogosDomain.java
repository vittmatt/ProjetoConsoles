package br.com.API.projetoGame.consoles.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class JogosDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogos;

    @NotNull
    @Length(min = 1, max = 80)
    private String nome;

    @NotNull
    @Length(min = 1, max = 1000)
    private String descricao;

    @NotBlank
    @Length(min = 1, max = 30)
    //TODO da para transformar em um ENUM
    private String genero;

    @ManyToOne
    @JsonBackReference
    private NintendoDomain nintendo;

    private final LocalDateTime dataDeLancamento = LocalDateTime.now();

    public JogosDomain() {
    }

    public JogosDomain(String nome, String descricao, String genero, NintendoDomain nintendo) {
        this.nome = nome;
        this.descricao = descricao;
        this.genero = genero;
        this.nintendo = nintendo;
    }

    public Long getIdJogos() {
        return idJogos;
    }

    public void setIdJogos(Long novoIdJogos) {
        this.idJogos = novoIdJogos;
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

    public NintendoDomain getNintendo() {
        return nintendo;
    }

    public void setNintendo(NintendoDomain nintendo) {
        this.nintendo = nintendo;
    }

    public LocalDateTime getDataDeLancamento() {
        return dataDeLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogosDomain jogosDomain = (JogosDomain) o;
        return Objects.equals(this.nome, jogosDomain.nome) && Objects.equals(this.descricao, jogosDomain.descricao) && Objects.equals(this.genero, jogosDomain.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.descricao, this.genero);
    }
}
