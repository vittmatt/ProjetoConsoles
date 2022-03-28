package br.com.projetoGame.consoles.models;

import br.com.projetoGame.consoles.models.enums.ModoDesempenho;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nintendo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsole;
    @NotBlank @Length(min = 1, max = 36)
    private String apelidoConsole;
    @Enumerated(EnumType.STRING)
    private ModoDesempenho modoDesempenho = ModoDesempenho.MODO_PADRAO;
    @JsonManagedReference
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

    public Long getIdConsole() {
        return idConsole;
    }

    public void setIdConsole(Long idConsole) {
        this.idConsole = idConsole;
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
