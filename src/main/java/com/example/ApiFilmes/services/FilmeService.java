package com.example.ApiFilmes.services;

import com.example.ApiFilmes.entities.Filmes;
import com.example.ApiFilmes.repositories.FilmeRepository;
import com.example.ApiFilmes.services.exceptions.DatabaseException;
import com.example.ApiFilmes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Filmes insert(Filmes obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Filmes update(Long id, Filmes obj) {
        Filmes entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Filmes entity, Filmes obj) {
        entity.setNome(obj.getNome());
        entity.setDescricao(obj.getDescricao());
        entity.setGeneros(obj.getGeneros());
        entity.setDiretor(obj.getDiretor());
        entity.setStatus(obj.getStatus());
    }


}
