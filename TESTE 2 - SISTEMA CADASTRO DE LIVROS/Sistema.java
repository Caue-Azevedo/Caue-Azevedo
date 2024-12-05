package com.senai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    // Função para "limpar" a tela do terminal (apenas insere novas linhas)
    public static void limparTela() {
        System.out.print("\n\n\n\n\n\n\n");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Livro> livros = new ArrayList<>();
        List<Genero> generos = inicializarGeneros();

        // Laço do menu
        while (true) {
            System.out.println("\n\n|============================================|");
            System.out.println("| Escolha uma opção:                         |");
            System.out.println("| 1) Cadastrar novo livro                    |");
            System.out.println("| 2) Ver todos os livros                     |");
            System.out.println("| 3) Ver todos os livros de um gênero        |");
            System.out.println("| 4) Buscar um livro por título ou autor     |");
            System.out.println("| 9) Sair                                    |");
            System.out.println("|============================================|");
            System.out.print("| Sua escolha: ");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro(scan, livros, generos);
                    break;
                case 2:
                    listarLivros(livros);
                    break;
                case 3:
                    listarLivrosPorGenero(scan, livros, generos);
                    break;
                case 4:
                    buscarLivro(scan, livros);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("| Opção inválida.                           |");
            }
        }
    }

    private static List<Genero> inicializarGeneros() {
        List<Genero> generos = new ArrayList<>();
        for (Genero genero : Genero.values  ()) {
            generos.add(genero);
        }
        return generos;
    }

    private static void cadastrarLivro(Scanner scan, List<Livro> livros, List<Genero> generos) {
        limparTela();

        System.out.println("|============================================|");
        System.out.print("| Digite o título do livro: ");
        String titulo = scan.nextLine();

        System.out.print("| Digite o nome do autor: ");
        String nomeAutor = scan.nextLine();
        System.out.print("| Digite o sobrenome do autor: ");
        String sobrenomeAutor = scan.nextLine();
        Pessoa autor = new Pessoa(nomeAutor, sobrenomeAutor);

        System.out.println("|--------------------------------------------|");
        System.out.println("| Escolha um gênero:                         |");
        for (Genero genero : generos) {
            System.out.println("| " + genero.getCodigo() + " - " + genero.getNome());
        }
        System.out.print("| Sua escolha: ");
        int codigoGenero = scan.nextInt();

        scan.nextLine();
        Genero generoSelecionado = null;
        for (Genero genero : generos) {
            if (genero.getCodigo() == codigoGenero) {
                generoSelecionado = genero;
                break;
            }
        }

        if (generoSelecionado != null) {
            Livro livro = new Livro(titulo, autor, generoSelecionado);
            livros.add(livro);
            System.out.println("| Livro cadastrado com sucesso!              |");
            System.out.println("|--------------------------------------------|");
        } else {
            System.out.println("| Gênero inválido.                           |");
        }
    }

    private static void listarLivros(List<Livro> livros) {
        limparTela();
        System.out.println("|============================================|");
        if (livros.isEmpty()) {
            System.out.println("| Não há livros cadastrados.                 |");
        } else {
            System.out.println("| Lista de Livros:                           |");
            System.out.println("|--------------------------------------------|");
            for (Livro livro : livros) {
                System.out.println("| Título: " + livro.getTitulo());
                System.out.println("| Autor: " + livro.getAutor().getNomeCompleto());
                System.out.println("| Gênero: " + livro.getGenero().getNome());
                System.out.println("|--------------------------------------------|");
            }
        }
        System.out.println("|============================================|");
    }

    private static void listarLivrosPorGenero(Scanner scan, List<Livro> livros, List<Genero> generos) {
        limparTela();
        System.out.println("|============================================|");
        System.out.println("| Escolha um gênero:                         |");
        for (Genero genero : generos) {
            System.out.println("| " + genero.getCodigo() + " - " + genero.getNome());
        }
        System.out.print("| Sua escolha: ");
        int codigoGenero = scan.nextInt();
        scan.nextLine();

        Genero generoSelecionado = null;
        for (Genero genero : generos) {
            if (genero.getCodigo() == codigoGenero) {
                generoSelecionado = genero;
                break;
            }
        }

        if (generoSelecionado != null) {
            boolean encontrou = false;
            for (Livro livro : livros) {
                if (livro.getGenero().equals(generoSelecionado)) {
                    System.out.println("| Título: " + livro.getTitulo());
                    System.out.println("| Autor: " + livro.getAutor().getNomeCompleto());
                    System.out.println("| Gênero: " + livro.getGenero().getNome());
                    System.out.println("|--------------------------------------------|");
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("| Não há livros deste gênero.               |");
            }
        } else {
            System.out.println("| Gênero inválido.                           |");
        }
        System.out.println("|============================================|");
    }

    private static void buscarLivro(Scanner scan, List<Livro> livros) {
        limparTela();
        System.out.println("|============================================|");
        System.out.print("| Digite o título ou autor do livro: ");
        String busca = scan.nextLine().toLowerCase();
        boolean encontrou = false;

        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(busca) ||
                    livro.getAutor().getNomeCompleto().toLowerCase().contains(busca)) {
                System.out.println("| Título: " + livro.getTitulo());
                System.out.println("| Autor: " + livro.getAutor().getNomeCompleto());
                System.out.println("| Gênero: " + livro.getGenero().getNome());
                System.out.println("|--------------------------------------------|");
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("| Nenhum livro encontrado.                  |");
        }
        System.out.println("|============================================|");
    }
}
