package br.com.projetoGame.consoles.controller;

import br.com.projetoGame.consoles.controller.dto.JogadorDto;
import br.com.projetoGame.consoles.controller.form.JogadorForm;
import br.com.projetoGame.consoles.models.Jogador;
import br.com.projetoGame.consoles.repository.JogadorRepository;
import br.com.projetoGame.consoles.repository.NintendoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;
    @Autowired
    private NintendoRepository nintendoRepository;

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
    public ResponseEntity<JogadorDto> cadastrarJogador(@RequestBody @Valid  JogadorForm jogadorForm, UriComponentsBuilder uriBuilder) {
        Jogador jogador = jogadorForm.converter();
        jogadorRepository.save(jogador);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(jogador.getId()).toUri();
        return ResponseEntity.created(uri).body(new JogadorDto(jogador));
    }
}
