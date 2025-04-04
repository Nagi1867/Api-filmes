package com.example.ApiFilmes.services;

import com.example.ApiFilmes.entities.Filmes;
import com.example.ApiFilmes.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repository;

    public List<Filmes> findAll() {
        return repository.findAll();
    }

    public Filmes findById(Long id) {
        Optional<Filmes> obj = repository.findById(id);
        return obj.get();
    }

    public Filmes insert(Filmes obj) {
        return repository.save(obj);
    }
}
