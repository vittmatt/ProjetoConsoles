package br.com.projetoGame.consoles.controller;

import br.com.projetoGame.consoles.controller.dto.NintendoDto;
import br.com.projetoGame.consoles.controller.form.NintendoForm;
import br.com.projetoGame.consoles.models.Nintendo;
import br.com.projetoGame.consoles.repository.JogadorRepository;
import br.com.projetoGame.consoles.repository.NintendoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogador/{id}/consoles")
public class NintendoController {

    @Autowired
    private NintendoRepository nintendoRepository;
    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping
    public List<NintendoDto> lista() {
        List<Nintendo> nintendo = nintendoRepository.findAll();
        return NintendoDto.converte(nintendo);
    }

    @GetMapping(path = "/{idConsole}")
    public ResponseEntity<NintendoDto> listarConsleEspecifico(@PathVariable Long idConsole) {
        Optional<Nintendo> nintendo = nintendoRepository.findById(idConsole);
        return nintendo
                .map(value -> ResponseEntity.ok(new NintendoDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    @Transactional
    public ResponseEntity<NintendoDto> cadastrar(@RequestBody @Valid NintendoForm nintendoForm, UriComponentsBuilder uriBuilder, @PathVariable Long id) {
        Nintendo nintendo = nintendoForm.converte(jogadorRepository, id);
        nintendoRepository.save(nintendo);
        URI uri = uriBuilder
                .path("/jogador/{id}/consoles/{idConsole}")
                .buildAndExpand(nintendo.getJogador().getId(), nintendo.getIdConsole())
                .toUri();
        return ResponseEntity.created(uri).body(new NintendoDto(nintendo));
    }

    @PutMapping(path = "/{idConsole}")
    @Transactional
    public ResponseEntity<NintendoDto> atualizar(@RequestBody @Valid NintendoForm nintendoForm, @PathVariable Long idConsole) {
        Optional<Nintendo> optionalNintendo = nintendoRepository.findById(idConsole);
        return optionalNintendo.map(value -> {
                    Nintendo nintendo = nintendoForm.atualiza(value);
                    return ResponseEntity.ok(new NintendoDto(nintendo));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping(path = "/{idConsole}")
    @Transactional
    public ResponseEntity<Object> deleta(@PathVariable Long idConsole) {
        Optional<Nintendo> nintendoOptional = nintendoRepository.findById(idConsole);
        return nintendoOptional.map(value -> {
                    nintendoRepository.deleteById(idConsole);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
