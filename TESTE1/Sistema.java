package com.senai.FormaGeometrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    // = Função para "limpar" a tela do terminal (apenas insere novas linhas) = //
    public static void limparTela() {
        System.out.print("\n\n\n\n\n\n\n");
    }

    // = Função para exibir o menu principal = //
    public void menuInicial() {
        Scanner scan = new Scanner(System.in);

        // = Listas para armazenar as formas geométricas criadas = //
        List<Retangulo> retangulos = new ArrayList<>();
        List<Circulo> circulos = new ArrayList<>();
        List<Quadrado> quadrados = new ArrayList<>();
        List<Trapezio> trapezios = new ArrayList<>();
        List<Triangulo> triangulos = new ArrayList<>();

        int escolha;
        int contador = 0; // = Limita a criação de formas (máximo de 5 no total) = //

        // = Laço do menu = //
        do {
            System.out.println("\n\n|============================================|");
            System.out.println("| Qual forma geométrica deseja utilizar?:    |");
            System.out.println("| 1) Retângulo                               |");
            System.out.println("| 2) Círculo                                 |");
            System.out.println("| 3) Quadrado                                |");
            System.out.println("| 4) Trapézio                                |");
            System.out.println("| 5) Triângulo                               |");
            System.out.println("| 6) Sair                                    |");
            System.out.println("|============================================|");
            System.out.print("| Sua escolha: ");
            escolha = scan.nextInt();

            // = Switch para processar as opções de forma geométrica = //
            switch (escolha) {
                case 1: // Caso o usuário escolha 'Retângulo' //
                    if (contador < 5) {
                        Retangulo ret = new Retangulo(); // = Criação de um novo retângulo = //
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o retângulo, insira os dados:        |");
                        System.out.print("|  Insira o valor da base: ");
                        ret.base = scan.nextFloat(); // = Leitura da base = //
                        System.out.print("|  Insira o valor da altura: ");
                        ret.altura = scan.nextFloat(); // = Leitura da altura = //
                        retangulos.add(ret); // = Adiciona o retângulo à lista = //
                        contador++; // = Incrementa o contador de formas = //
                    } else {
                        System.out.println("Limite de formas atingido!"); // = Se o limite de formas for atingido = //
                    }
                    break;

                case 2: // Caso o usuário escolha 'Círculo' //
                    if (contador < 5) {
                        Circulo circ = new Circulo(); // = Criação de um novo círculo = //
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o círculo, insira os dados:          |");
                        System.out.print("|  Insira o valor do raio: ");
                        circ.raio = scan.nextFloat(); // = Leitura do raio = //
                        circulos.add(circ); // = Adiciona o círculo à lista = //
                        contador++; // = Incrementa o contador de formas = //
                    } else {
                        System.out.println("Limite de formas atingido!"); // = Se o limite de formas for atingido = //
                    }
                    break;

                case 3: // Caso o usuário escolha 'Quadrado' //
                    if (contador < 5) {
                        Quadrado quad = new Quadrado(); // = Criação de um novo quadrado = //
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o quadrado, insira os dados:         |");
                        System.out.print("|  Insira o valor do lado: ");
                        quad.lado = scan.nextFloat(); // = Leitura do lado do quadrado = //
                        quadrados.add(quad); // = Adiciona o quadrado à lista = //
                        contador++; // = Incrementa o contador de formas = //
                    } else {
                        System.out.println("Limite de formas atingido!"); // = Se o limite de formas for atingido = //
                    }
                    break;

                case 4: // Caso o usuário escolha 'Trapézio' //
                    if (contador < 5) {
                        Trapezio trap = new Trapezio(); // = Criação de um novo trapézio = //
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o trapézio, insira os dados:         |");
                        System.out.print("|  Insira o valor da base maior: ");
                        trap.baseMaior = scan.nextFloat(); // = Leitura da base maior do trapézio = //
                        System.out.print("|  Insira o valor da base menor: ");
                        trap.baseMenor = scan.nextFloat(); // = Leitura da base menor do trapézio = //
                        System.out.print("|  Insira o valor do lado 1: ");
                        trap.lado1 = scan.nextFloat(); // = Leitura do lado 1 do trapézio = //
                        System.out.print("|  Insira o valor do lado 2: ");
                        trap.lado2 = scan.nextFloat(); // = Leitura do lado 2 do trapézio = //
                        trapezios.add(trap); // = Adiciona o trapézio à lista = //
                        contador++; // = Incrementa o contador de formas = //
                    } else {
                        System.out.println("Limite de formas atingido!"); // = Se o limite de formas for atingido = //
                    }
                    break;

                case 5: // Caso o usuário escolha 'Triângulo' //
                    if (contador < 5) {
                        Triangulo tri = new Triangulo(); // = Criação de um novo triângulo = //
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o triângulo, insira os dados:        |");
                        System.out.print("|  Insira o valor da base: ");
                        tri.base = scan.nextFloat(); // = Leitura da base do triângulo = //
                        System.out.print("|  Insira o valor da altura: ");
                        tri.altura = scan.nextFloat(); // = Leitura da altura do triângulo = //
                        triangulos.add(tri); // = Adiciona o triângulo à lista = //
                        contador++; // = Incrementa o contador de formas = //
                    } else {
                        System.out.println("Limite de formas atingido!"); // = Se o limite de formas for atingido = //
                    }
                    break;

                case 6: // Caso o usuário escolha 'Sair' //
                    System.out.println("Saindo do programa..."); // = Mensagem de saída = //

                    // = Exibe os resultados de todas as formas geométricas cadastradas = //
                    int iRetangulo = 1;
                    for (Retangulo ret : retangulos) {
                        ret.calculoPerimetro(ret.base, ret.altura); // = Calcula o perímetro do retângulo = //
                        ret.calculoArea(ret.base, ret.altura); // = Calcula a área do retângulo = //
                        System.out.println(iRetangulo + "º Retângulo - Perímetro: " + ret.perimetro + ", Área: " + ret.area); // = Exibe os resultados = //
                        iRetangulo++;
                    }

                    int iCirculo = 1;
                    for (Circulo circ : circulos) {
                        circ.calculoPerimetro(circ.raio); // = Calcula o perímetro do círculo = //
                        circ.calculoArea(circ.raio); // = Calcula a área do círculo = //
                        System.out.println(iCirculo + "º Círculo - Perímetro: " + circ.perimetro + ", Área: " + circ.area); // = Exibe os resultados = //
                        iCirculo++;
                    }

                    int iQuadrado = 1;
                    for (Quadrado quad : quadrados) {
                        quad.calculoPerimetro(quad.lado); // = Calcula o perímetro do quadrado = //
                        quad.calculoArea(quad.lado); // = Calcula a área do quadrado = //
                        System.out.println(iQuadrado + "º Quadrado - Perímetro: " + quad.perimetro + ", Área: " + quad.area); // = Exibe os resultados = //
                        iQuadrado++;
                    }

                    int iTrapezio = 1;
                    for (Trapezio trap : trapezios) {
                        trap.calculoPerimetro(trap.lado1, trap.lado2, trap.baseMaior, trap.baseMenor); // = Calcula o perímetro do trapézio = //
                        trap.calculoArea(trap.baseMaior, trap.baseMenor, trap.altura); // = Calcula a área do trapézio = //
                        System.out.println(iTrapezio + "º Trapézio - Perímetro: " + trap.perimetro + ", Área: " + trap.area); // = Exibe os resultados = //
                        iTrapezio++;
                    }

                    int iTriangulo = 1;
                    for (Triangulo tri : triangulos) {
                        tri.calculoPerimetro(tri.base); // = Calcula o perímetro do triângulo = //
                        tri.calculoArea(tri.base, tri.altura); // = Calcula a área do triângulo = //
                        System.out.println(iTriangulo + "º Triângulo - Perímetro: " + tri.perimetro + ", Área: " + tri.area); // = Exibe os resultados = //
                        iTriangulo++;
                    }
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente."); // = Mensagem de erro para opção inválida = //
                    limparTela(); // = Limpa a tela = //
                    break;
            }
        } while (escolha != 6); // = O programa continua até o usuário escolher sair = //
    }

    // = Função principal para rodar o programa = //
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.menuInicial(); // = Chama a função que exibe o menu inicial = //
    }
}
