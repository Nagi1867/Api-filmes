package com.example.ApiFilmes.config;

import com.example.ApiFilmes.entities.Diretor;
import com.example.ApiFilmes.entities.Filmes;
import com.example.ApiFilmes.repositories.DiretorRepository;
import com.example.ApiFilmes.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    @Override
    public void run(String... args) throws Exception {
        Diretor diretor1 = new Diretor(null, "Jorge Lucas");

        diretorRepository.save(diretor1);

        Filmes filme1 = new Filmes(null, "O gato de botas", "Um gato de botas", "Aventura, Fantasia", diretor1, false);
        Filmes filme2 = new Filmes(null, "Rapunzel", "A mina do cabelo longo", "Romance, Fantasia", diretor1, false);

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));
    }
}
