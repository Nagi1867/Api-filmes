package com.example.ApiFilmes.repositories;

import com.example.ApiFilmes.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
