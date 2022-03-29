package br.com.API.projetoGame.consoles.controller;

import br.com.API.projetoGame.consoles.controller.dto.JogadorDto;
import br.com.API.projetoGame.consoles.controller.form.JogadorForm;
import br.com.API.projetoGame.consoles.domains.JogadorDomain;
import br.com.API.projetoGame.consoles.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<JogadorDto> listarJogadores(String nome){
        if(nome == null) {
            List<JogadorDomain> jogadores = jogadorRepository.findAll();
            return JogadorDto.converter(jogadores);
        }
        List<JogadorDomain> jogadores = jogadorRepository.findByNome(nome);
        return JogadorDto.converter(jogadores);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<JogadorDto> cadastrarJogador(@RequestBody @Valid  JogadorForm jogadorForm, UriComponentsBuilder uriBuilder) {
        JogadorDomain jogador = jogadorForm.converter();
        jogadorRepository.save(jogador);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(jogador.getId()).toUri();
        return ResponseEntity.created(uri).body(new JogadorDto(jogador));
    }

    @GetMapping(path = "/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<JogadorDto> detalhar(@PathVariable Long id) {
        Optional<JogadorDomain> jogador = jogadorRepository.findById(id);
        return jogador
                .map(value -> ResponseEntity.ok(new JogadorDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<JogadorDto> atualizar(@PathVariable Long id, @RequestBody @Valid  JogadorForm jogadorForm) {
        Optional<JogadorDomain> optionalJogador = jogadorRepository.findById(id);
        return optionalJogador.map(value -> {
                    JogadorDomain jogador = jogadorForm.atualizar(id, jogadorRepository);
                    return ResponseEntity.ok(new JogadorDto(jogador));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        Optional<JogadorDomain> jogadorOptional = jogadorRepository.findById(id);
        return jogadorOptional.map(value -> {
                    jogadorRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
