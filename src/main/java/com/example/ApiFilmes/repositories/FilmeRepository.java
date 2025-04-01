package com.example.ApiFilmes.repositories;

import com.example.ApiFilmes.entities.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filmes, Long> {
}
