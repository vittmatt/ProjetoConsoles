package br.com.projetoGame.consoles.controller;

import br.com.projetoGame.consoles.models.Jogos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/jogos")//"/jogador/{id}/consoles/{id}/jogos"
public class JogosController {

//    @GetMapping()
//    public List<Jogos> lista() {
//        Jogos jogos = new Jogos("Dark souls", "Ação", "Um jogo muito dificil");
//        return Arrays.asList(jogos, jogos, jogos);
//    }
}
