package com.example.ApiFilmes.resources;

import com.example.ApiFilmes.entities.Filmes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeResource {
    
    @GetMapping
    public ResponseEntity<Filmes> findAll(){
        Filmes filmes = new Filmes(1L, "O gato de botas", "Um gato de botas", "Aventura, Fantasia", "Jorge Lucas", false);
        return ResponseEntity.ok().body(filmes);
    }
}
