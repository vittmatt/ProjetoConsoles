package br.com.API.projetoGame.consoles.controller;

import br.com.API.projetoGame.consoles.controller.dto.NintendoDto;
import br.com.API.projetoGame.consoles.controller.form.NintendoForm;
import br.com.API.projetoGame.consoles.domains.NintendoDomain;
import br.com.API.projetoGame.consoles.repository.JogadorRepository;
import br.com.API.projetoGame.consoles.repository.NintendoRepository;
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
@RequestMapping("/jogador/{id}/nintendo")
public class NintendoController {

    @Autowired
    private NintendoRepository nintendoRepository;
    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<NintendoDto> lista() {
        List<NintendoDomain> nintendo = nintendoRepository.findAll();
        return NintendoDto.converte(nintendo);
    }

    @GetMapping(path = "/{idNintendo}")
    @Transactional(readOnly = true)
    public ResponseEntity<NintendoDto> listarConsleEspecifico(@PathVariable Long idNintendo) {
        Optional<NintendoDomain> nintendo = nintendoRepository.findById(idNintendo);
        return nintendo
                .map(value -> ResponseEntity.ok(new NintendoDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    @Transactional
    public ResponseEntity<NintendoDto> cadastrar(@RequestBody @Valid NintendoForm nintendoForm,
                                                 UriComponentsBuilder uriBuilder,
                                                 @PathVariable Long id) {
        NintendoDomain nintendo = nintendoForm.converte(jogadorRepository, id);
        nintendoRepository.save(nintendo);
        URI uri = uriBuilder
                .path("/jogador/{id}/nintendo/{idNintendo}")
                .buildAndExpand(nintendo.getJogador().getId(), nintendo.getIdNintendo())
                .toUri();
        return ResponseEntity.created(uri).body(new NintendoDto(nintendo));
    }

    @PutMapping(path = "/{idNintendo}")
    @Transactional
    public ResponseEntity<NintendoDto> atualizar(@RequestBody @Valid NintendoForm nintendoForm,
                                                 @PathVariable Long idNintendo) {
        Optional<NintendoDomain> optionalNintendo = nintendoRepository.findById(idNintendo);
        return optionalNintendo.map(value -> {
                    NintendoDomain nintendo = nintendoForm.atualiza(value);
                    return ResponseEntity.ok(new NintendoDto(nintendo));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping(path = "/{idNintendo}")
    @Transactional
    public ResponseEntity<Object> deleta(@PathVariable Long idNintendo) {
        Optional<NintendoDomain> nintendoOptional = nintendoRepository.findById(idNintendo);
        return nintendoOptional.map(value -> {
                    nintendoRepository.deleteById(idNintendo);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
