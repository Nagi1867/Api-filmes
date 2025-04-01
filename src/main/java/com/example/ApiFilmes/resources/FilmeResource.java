package com.example.ApiFilmes.resources;

import com.example.ApiFilmes.entities.Filmes;
import com.example.ApiFilmes.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeResource {
    @Autowired
    private FilmeService service;

    @GetMapping
    public ResponseEntity<List<Filmes>> findAll(){
        List<Filmes> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filmes> findById(@PathVariable Long id) {
        Filmes obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
