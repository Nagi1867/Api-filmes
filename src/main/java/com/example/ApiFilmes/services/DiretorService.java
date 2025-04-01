package com.example.ApiFilmes.services;

import com.example.ApiFilmes.entities.Diretor;
import com.example.ApiFilmes.repositories.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {
    @Autowired
    private DiretorRepository repository;

    public List<Diretor> findAll() {
        return repository.findAll();
    }

    public Diretor findById(Long id) {
        Optional<Diretor> obj = repository.findById(id);
        return obj.get();
    }
}
