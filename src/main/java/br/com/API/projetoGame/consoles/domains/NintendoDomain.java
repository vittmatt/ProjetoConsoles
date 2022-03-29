package br.com.API.projetoGame.consoles.domains;

import br.com.API.projetoGame.consoles.domains.enums.ModoDesempenho;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NintendoDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNintendo;

    @NotBlank
    @Length(min = 1, max = 36)
    private String nomeNintendo;

    @Enumerated(EnumType.STRING)
    private ModoDesempenho modoDesempenho = ModoDesempenho.MODO_PADRAO;

    @JsonManagedReference
    @OneToMany(mappedBy = "nintendo")
    private final List<JogosDomain> jogos = new ArrayList<>();

    @ManyToOne
    private JogadorDomain jogador;

    public NintendoDomain() {
    }

    public NintendoDomain(String nomeNintendo, ModoDesempenho modoDesempenho, JogadorDomain jogador) {
        this.nomeNintendo = nomeNintendo;
        this.modoDesempenho = modoDesempenho;
        this.jogador = jogador;
    }

    public Long getIdNintendo() {
        return idNintendo;
    }

    public void setIdNintendo(Long idNintendo) {
        this.idNintendo = idNintendo;
    }

    public ModoDesempenho getModoDesempenho() {
        return modoDesempenho;
    }

    public void setModoDesempenho(ModoDesempenho modoDesempenho) {
        this.modoDesempenho = modoDesempenho;
    }

    public List<JogosDomain> getJogos() {
        return jogos;
    }

    public JogadorDomain getJogador() {
        return jogador;
    }

    public String getNomeNintendo() {
        return nomeNintendo;
    }

    public void setNomeNintendo(String nomeNintendo) {
        this.nomeNintendo = nomeNintendo;
    }

    public void setJogador(JogadorDomain jogador) {
        this.jogador = jogador;
    }
}
