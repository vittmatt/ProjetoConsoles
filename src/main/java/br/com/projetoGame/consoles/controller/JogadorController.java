package br.com.projetoGame.consoles.controller;

import br.com.projetoGame.consoles.controller.dto.JogadorDto;
import br.com.projetoGame.consoles.controller.form.JogadorForm;
import br.com.projetoGame.consoles.models.Jogador;
import br.com.projetoGame.consoles.repository.JogadorRepository;
import br.com.projetoGame.consoles.repository.NintendoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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
    public List<JogadorDto> listarJogadores(String nome){
        if(nome == null) {
            List<Jogador> jogadores = jogadorRepository.findAll();
            return JogadorDto.converter(jogadores);
        }
        List<Jogador> jogadores = jogadorRepository.findByNome(nome);
        return JogadorDto.converter(jogadores);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<JogadorDto> cadastrarJogador(@RequestBody @Valid  JogadorForm jogadorForm, UriComponentsBuilder uriBuilder) {
        Jogador jogador = jogadorForm.converter();
        jogadorRepository.save(jogador);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(jogador.getId()).toUri();
        return ResponseEntity.created(uri).body(new JogadorDto(jogador));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<JogadorDto> detalhar(@PathVariable Long id) {
        Optional<Jogador> jogador = jogadorRepository.findById(id);
        return jogador
                .map(value -> ResponseEntity.ok(new JogadorDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<JogadorDto> atualizar(@PathVariable Long id, @RequestBody @Valid  JogadorForm jogadorForm) {
        Optional<Jogador> optionalJogador = jogadorRepository.findById(id);
        return optionalJogador.map(value -> {
                    Jogador jogador = jogadorForm.atualizar(id, jogadorRepository);
                    return ResponseEntity.ok(new JogadorDto(jogador));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        Optional<Jogador> jogadorOptional = jogadorRepository.findById(id);
        return jogadorOptional.map(value -> {
                    jogadorRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
