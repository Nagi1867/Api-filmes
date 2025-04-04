package com.example.ApiFilmes.config;

import com.example.ApiFilmes.entities.Diretor;
import com.example.ApiFilmes.entities.Filmes;
import com.example.ApiFilmes.entities.Genero;
import com.example.ApiFilmes.enums.FilmeStatus;
import com.example.ApiFilmes.repositories.DiretorRepository;
import com.example.ApiFilmes.repositories.FilmeRepository;
import com.example.ApiFilmes.repositories.GeneroRepository;
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

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public void run(String... args) throws Exception {
        Diretor diretor1 = new Diretor(null, "Jorge Lucas");

        diretorRepository.save(diretor1);

        Genero genero1 = new Genero(null, "Aventura");
        Genero genero2 = new Genero(null, "Fantasia");
        Genero genero3 = new Genero(null, "Romance");

        generoRepository.saveAll(Arrays.asList(genero1, genero2, genero3));

        Filmes filme1 = new Filmes(null, "O gato de botas", "Um gato de botas",  diretor1, FilmeStatus.ASSISTIDO);
        Filmes filme2 = new Filmes(null, "Rapunzel", "A mina do cabelo longo", diretor1, FilmeStatus.NAO_ASSISTIDO);

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));

        filme1.getGeneros().addAll(Arrays.asList(genero1, genero2));
        filme2.getGeneros().addAll(Arrays.asList(genero2, genero3));

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));

    }
}
