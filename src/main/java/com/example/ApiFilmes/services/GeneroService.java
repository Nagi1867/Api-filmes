package com.example.ApiFilmes.services;

import com.example.ApiFilmes.entities.Genero;
import com.example.ApiFilmes.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository repository;

    public List<Genero> findAll() {
        return repository.findAll();
    }

    public Genero findById(Long id) {
        Optional<Genero> obj = repository.findById(id);
        return obj.get();
    }
}
