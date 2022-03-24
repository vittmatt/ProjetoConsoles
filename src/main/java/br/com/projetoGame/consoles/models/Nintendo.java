package br.com.projetoGame.consoles.models;

import br.com.projetoGame.consoles.models.enums.ModoDesempenho;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nintendo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private final ModoDesempenho modoDesempenho = ModoDesempenho.MODO_PADRAO;
    @OneToMany(mappedBy = "nintendo")
    private final List<Jogos> jogos = new ArrayList<>();
    @ManyToOne
    private Jogador jogador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModoDesempenho getModoDesempenho() {
        return modoDesempenho;
    }

    public List<Jogos> getJogos() {
        return jogos;
    }

    public Jogador getJogador() {
        return jogador;
    }


}
