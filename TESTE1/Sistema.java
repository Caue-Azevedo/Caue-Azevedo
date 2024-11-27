package com.senai.FormaGeometrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    public static void limparTela() {
        System.out.print("\n\n\n\n\n\n\n");
    }

    public void menuInicial() {
        Scanner scan = new Scanner(System.in);

        List<Retangulo> retangulos = new ArrayList<>();
        List<Circulo> circulos = new ArrayList<>();
        List<Quadrado> quadrados = new ArrayList<>();
        List<Trapezio> trapezios = new ArrayList<>();
        List<Triangulo> triangulos = new ArrayList<>();

        int escolha;
        int contador = 0;

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

            switch (escolha) {
                case 1:
                    if (contador < 5) {
                        Retangulo ret = new Retangulo();
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o retângulo, insira os dados:        |");
                        System.out.print("|  Insira o valor da base: ");
                        ret.base = scan.nextFloat();
                        System.out.print("|  Insira o valor da altura: ");
                        ret.altura = scan.nextFloat();
                        retangulos.add(ret);
                        contador++;
                    } else {
                        System.out.println("Limite de formas atingido!");
                    }
                    break;

                case 2:
                    if (contador < 5) {
                        Circulo circ = new Circulo();
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o círculo, insira os dados:          |");
                        System.out.print("|  Insira o valor do raio: ");
                        circ.raio = scan.nextFloat();
                        circulos.add(circ);
                        contador++;
                    } else {
                        System.out.println("Limite de formas atingido!");
                    }
                    break;

                case 3:
                    if (contador < 5) {
                        Quadrado quad = new Quadrado();
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o quadrado, insira os dados:         |");
                        System.out.print("|  Insira o valor do lado: ");
                        quad.lado = scan.nextFloat();
                        quadrados.add(quad);
                        contador++;
                    } else {
                        System.out.println("Limite de formas atingido!");
                    }
                    break;

                case 4:
                    if (contador < 5) {
                        Trapezio trap = new Trapezio();
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o trapézio, insira os dados:         |");
                        System.out.print("|  Insira o valor da base maior: ");
                        trap.baseMaior = scan.nextFloat();
                        System.out.print("|  Insira o valor da base menor: ");
                        trap.baseMenor = scan.nextFloat();
                        System.out.print("|  Insira o valor do lado 1: ");
                        trap.lado1 = scan.nextFloat();
                        System.out.print("|  Insira o valor do lado 2: ");
                        trap.lado2 = scan.nextFloat();
                        trapezios.add(trap);
                        contador++;
                    } else {
                        System.out.println("Limite de formas atingido!");
                    }
                    break;

                case 5:
                    if (contador < 5) {
                        Triangulo tri = new Triangulo();
                        System.out.println("|====================================================|");
                        System.out.println("| Você escolheu o triângulo, insira os dados:        |");
                        System.out.print("|  Insira o valor da base: ");
                        tri.base = scan.nextFloat();
                        System.out.print("|  Insira o valor da altura: ");
                        tri.altura = scan.nextFloat();
                        triangulos.add(tri);
                        contador++;
                    } else {
                        System.out.println("Limite de formas atingido!");
                    }
                    break;

                case 6:
                    System.out.println("Saindo do programa...");

                    // Numerando os resultados para cada forma separadamente
                    int iRetangulo = 1;
                    for (Retangulo ret : retangulos) {
                        ret.calculoPerimetro(ret.base, ret.altura);
                        ret.calculoArea(ret.base, ret.altura);
                        System.out.println(iRetangulo + "º Retângulo - Perímetro: " + ret.perimetro + ", Área: " + ret.area);
                        iRetangulo++;
                    }

                    int iCirculo = 1;
                    for (Circulo circ : circulos) {
                        circ.calculoPerimetro(circ.raio);
                        circ.calculoArea(circ.raio);
                        System.out.println(iCirculo + "º Círculo - Perímetro: " + circ.perimetro + ", Área: " + circ.area);
                        iCirculo++;
                    }

                    int iQuadrado = 1;
                    for (Quadrado quad : quadrados) {
                        quad.calculoPerimetro(quad.lado);
                        quad.calculoArea(quad.lado);
                        System.out.println(iQuadrado + "º Quadrado - Perímetro: " + quad.perimetro + ", Área: " + quad.area);
                        iQuadrado++;
                    }

                    int iTrapezio = 1;
                    for (Trapezio trap : trapezios) {
                        trap.calculoPerimetro(trap.lado1, trap.lado2, trap.baseMaior, trap.baseMenor);
                        trap.calculoArea(trap.baseMaior, trap.baseMenor, trap.altura);
                        System.out.println(iTrapezio + "º Trapézio - Perímetro: " + trap.perimetro + ", Área: " + trap.area);
                        iTrapezio++;
                    }

                    int iTriangulo = 1;
                    for (Triangulo tri : triangulos) {
                        tri.calculoPerimetro(tri.base);
                        tri.calculoArea(tri.base, tri.altura);
                        System.out.println(iTriangulo + "º Triângulo - Perímetro: " + tri.perimetro + ", Área: " + tri.area);
                        iTriangulo++;
                    }

                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    limparTela();
                    break;
            }
        } while (escolha != 6);
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.menuInicial();
    }
}
