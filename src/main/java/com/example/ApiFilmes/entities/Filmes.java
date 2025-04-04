package com.example.ApiFilmes.entities;

import com.example.ApiFilmes.enums.FilmeStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "tb_filme_genero",
            joinColumns = @JoinColumn(name = "filme_id"),
    inverseJoinColumns = @JoinColumn(name = "genero_id"))
    private Set<Genero> generos = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;
    private Integer status;

    public Filmes() {}

    public Filmes(Long id, String nome, String descricao, Diretor diretor, FilmeStatus status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.diretor = diretor;
        setStatus(status);
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

    public Set<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<Genero> generos) {
        this.generos = generos;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public FilmeStatus getStatus() {
        return FilmeStatus.valueOf(status);
    }

    public void setStatus(FilmeStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }
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
