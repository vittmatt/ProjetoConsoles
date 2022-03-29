package br.com.API.projetoGame.consoles.controller;

import br.com.API.projetoGame.consoles.controller.dto.JogosDto;
import br.com.API.projetoGame.consoles.controller.form.JogosForm;
import br.com.API.projetoGame.consoles.domains.JogosDomain;
import br.com.API.projetoGame.consoles.repository.JogosRepository;
import br.com.API.projetoGame.consoles.repository.NintendoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("jogador/{id}/nintendo/{idNintendo}/jogos")
public class JogosController {

    @Autowired
    private JogosRepository jogosRepository;

    @Autowired
    private NintendoRepository nintendoRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<JogosDto> lista() {
        return JogosDto.converte(jogosRepository);
    }

    @GetMapping("/{idJogos}")
    @Transactional(readOnly = true)
    public ResponseEntity<JogosDto> listaJogoEspecifico(@PathVariable Long idJogos) {
        return jogosRepository.findById(idJogos)
                .map(value -> ResponseEntity.ok(new JogosDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<JogosDto> cadastra(@RequestBody @Valid JogosForm jogosForm,
                                             UriComponentsBuilder uriBuilder,
                                             @PathVariable Long idNintendo) {
        JogosDomain jogo = jogosForm.converte(nintendoRepository, idNintendo);
        jogosRepository.save(jogo);
        URI uri = uriBuilder
                .path("/jogador/{id}/nintendo/{idNintendo}/jogos/{idJogos}")
                .buildAndExpand(jogo.getNintendo().getJogador().getId(), jogo.getNintendo().getIdNintendo(), jogo.getIdJogos())
                .toUri();
        return ResponseEntity.created(uri).body(new JogosDto(jogo));
    }

    @PutMapping(path = "/{idJogos}")
    @Transactional
    public ResponseEntity<JogosDto> atualiza(@RequestBody @Valid JogosForm jogosForm,
                                             @PathVariable Long idJogos) {
        return jogosRepository.findById(idJogos)
                .map(jogo -> ResponseEntity.ok(jogosForm.atualiza(jogo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{idJogos}")
    @Transactional
    public ResponseEntity<Object> deleta(@PathVariable Long idJogos) {
        return jogosRepository.findById(idJogos)
                .map(jogo -> {
                    jogosRepository.deleteById(idJogos);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
