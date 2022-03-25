package br.com.projetoGame.consoles.models;

import br.com.projetoGame.consoles.models.enums.ModoDesempenho;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nintendo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificadorConsole;
    private String apelidoConsole;
    @Enumerated(EnumType.STRING)
    private ModoDesempenho modoDesempenho = ModoDesempenho.MODO_PADRAO;
    @OneToMany(mappedBy = "nintendo")
    private final List<Jogos> jogos = new ArrayList<>();
    @ManyToOne
    private Jogador jogador;

    public Nintendo() {
    }

    public Nintendo(String apelidoConsole, ModoDesempenho modoDesempenho, Jogador jogador) {
        this.apelidoConsole = apelidoConsole;
        this.modoDesempenho = modoDesempenho;
        this.jogador = jogador;
    }

    public Long getIdentificadorConsole() {
        return identificadorConsole;
    }

    public void setIdentificadorConsole(Long identificadorConsole) {
        this.identificadorConsole = identificadorConsole;
    }

    public ModoDesempenho getModoDesempenho() {
        return modoDesempenho;
    }

    public void setModoDesempenho(ModoDesempenho modoDesempenho) {
        this.modoDesempenho = modoDesempenho;
    }

    public List<Jogos> getJogos() {
        return jogos;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public String getApelidoConsole() {
        return apelidoConsole;
    }

    public void setApelidoConsole(String apelidoConsole) {
        this.apelidoConsole = apelidoConsole;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
