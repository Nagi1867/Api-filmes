package com.example.ApiFilmes.repositories;

import com.example.ApiFilmes.entities.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {
}
