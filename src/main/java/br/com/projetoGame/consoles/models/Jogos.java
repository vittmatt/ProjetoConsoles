package br.com.projetoGame.consoles.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private LocalDate dataDeLancamento;

    public Jogos() {
    }

    public Jogos(String nome, String genero, String descricao, LocalDate dataDeLancamento) {
        this.nome = nome;
        this.genero = genero;
        this.descricao = descricao;
        this.dataDeLancamento = dataDeLancamento;
    }

    public String getNome() {
        return this.nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "nome: " + this.nome +
                ", descricao: " + this.descricao +
                ", genero: " + this.genero +
                ", Data de Lançamento: " + this.dataDeLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                '}';
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
