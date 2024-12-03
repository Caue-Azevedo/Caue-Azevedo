import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    // = Função para "limpar" a tela do terminal (apenas insere novas linhas) = //
    public static void limparTela() {
        System.out.print("\n\n\n\n\n\n\n");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Livro> livros = new ArrayList<>();
        List<Genero> generos = inicializarGeneros();

        // = Laço do menu = //
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
                    System.out.println("Opção inválida.");
            }
        }
    }
    // = ----------------------------- Lista dos gêneros ----------------------------- = //
    private static List<Genero> inicializarGeneros() {
        List<Genero> generos = new ArrayList<>();
        generos.add(new Genero(1, "Autoajuda                              |"));
        generos.add(new Genero(2, "Biografias e Histórias Reais           |"));
        generos.add(new Genero(3, "Educação e Didáticos                   |"));
        generos.add(new Genero(4, "História                               |"));
        generos.add(new Genero(5, "HQs, Mangás e Graphic Novels           |"));
        generos.add(new Genero(6, "Infantil                               |"));
        generos.add(new Genero(7, "Literatura e Ficção                    |"));
        generos.add(new Genero(8, "Religião e Espiritualidade             |"));
        generos.add(new Genero(9, "Romance                                |"));
        generos.add(new Genero(10, "Suspense                              |"));
        return generos;
    }

    // = ----------------------------------------------------------------------------- = //
    // = ---------------------- Função para cadastrar os livros ---------------------- = //
    private static void cadastrarLivro(Scanner scan, List<Livro> livros, List<Genero> generos) {
        limparTela();

        System.out.println("|============================================|");
        System.out.print("| Digite o título do livro: ");
        String titulo = scan.nextLine();

        System.out.print("| Digite o nome do autor: ");
        String nomeAutor = scan.nextLine();  // = Pega o nome do autor = //
        System.out.print("| Digite o sobrenome do autor: ");
        String sobrenomeAutor = scan.nextLine(); // = Pega o sobrenome do autor = //
        Pessoa autor = new Pessoa(nomeAutor, sobrenomeAutor); // = Adiciona o parametro à construr Pessoa da classe  = //

        System.out.println("|--------------------------------------------|");
        System.out.println("| Escolha um gênero:                         |");
        for (Genero genero : generos) {
            System.out.println("| " + genero.getCodigo() + " - " + genero.getNome());
        }
        System.out.print("| ");
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
            System.out.println("|Gênero inválido.                            |");
        }
    }

    private static void listarLivros(List<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    private static void listarLivrosPorGenero(Scanner scan, List<Livro> livros, List<Genero> generos) {
        System.out.println("Escolha um gênero:");
        for (Genero genero : generos) {
            System.out.println(genero.getCodigo() + " - " + genero.getNome());
        }
        int codigoGenero = scan.nextInt();
        scan.nextLine(); // Consome o newline
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
                    System.out.println(livro);
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Não há livros deste gênero.");
            }
        } else {
            System.out.println("Gênero inválido.");
        }
    }

    private static void buscarLivro(Scanner scan, List<Livro> livros) {
        System.out.print("Digite o título ou autor do livro: ");
        String busca = scan.nextLine().toLowerCase();
        boolean encontrou = false;

        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(busca) ||
                    livro.getAutor().getNomeCompleto().toLowerCase().contains(busca)) {
                System.out.println(livro);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro encontrado.");
        }
    }
}
