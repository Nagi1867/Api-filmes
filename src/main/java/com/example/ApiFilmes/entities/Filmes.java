package com.example.ApiFilmes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_filmes")
public class Filmes implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotBlank
    private String nome;
    @NotNull @NotBlank
    private String descricao;
    private String genero;
    @ManyToOne
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;
    private Boolean status;

    public Filmes() {}

    public Filmes(Long id, String nome, String descricao, String genero, Diretor diretor, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.genero = genero;
        this.diretor = diretor;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filmes filmes = (Filmes) o;
        return Objects.equals(id, filmes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
