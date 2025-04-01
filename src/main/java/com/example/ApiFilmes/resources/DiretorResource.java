package com.example.ApiFilmes.resources;

import com.example.ApiFilmes.entities.Diretor;
import com.example.ApiFilmes.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/diretores")
public class DiretorResource {
    @Autowired
    private DiretorService service;

    @GetMapping
    public ResponseEntity<List<Diretor>> findAll() {
        List<Diretor> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Diretor> findById(@PathVariable Long id) {
        Diretor obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
