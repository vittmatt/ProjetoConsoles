package br.com.projetoGame.consoles.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Jogos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String genero;
    @ManyToOne
    private Nintendo nintendo;
    private LocalDateTime dataDeLancamento = LocalDateTime.now();

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

    public Nintendo getNintendo() {
        return nintendo;
    }

    public void setNintendo(Nintendo nintendo) {
        this.nintendo = nintendo;
    }

    public LocalDateTime getDataDeLancamento() {
        return dataDeLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogos jogos = (Jogos) o;
        return Objects.equals(this.nome, jogos.nome) && Objects.equals(this.descricao, jogos.descricao) && Objects.equals(this.genero, jogos.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.descricao, this.genero);
    }
}
