package com.senai;

public class Livro {
    private String titulo;
    private Pessoa autor;
    private Genero genero;

    public Livro(String titulo, Pessoa autor, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return String.format("Título: %s | Autor: %s | Gênero: %s", titulo, autor.getNomeCompleto(), genero.getNome());
    }
}
