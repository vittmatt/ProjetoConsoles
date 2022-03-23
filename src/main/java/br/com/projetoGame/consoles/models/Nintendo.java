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

    public void baixarJogo(Jogos jogo) throws Exception {

    }

    public void desinstalarJogo(String jogoParaDesinstalar) {

    }

    public void atualizarJogo(String jogoAntigo, Jogos novoJogo) {

    }

    public void buscarJogoPeloNome(String jogoBuscado) {

    }

    public void buscarJogoPeloGenero(String genero) {

    }

    public void buscarJogoPeloAnoDeLancamento(int anoDeLancamento) {

    }

    public void getJogos() {

    }

}
