 package com.senai.FormaGeometrica;

import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FormaGeometrica[] formas = new FormaGeometrica[5];
        int contador = 0;
        int opcao;

        do {

            System.out.println("|============================================|");
            System.out.println("| Selecione uma das opções:                  |");
            System.out.println("| 1 - Retângulo                              |");
            System.out.println("| 2 - Círculo                                |");
            System.out.println("| 3 - Quadrado                               |");
            System.out.println("| 4 - Triângulo                              |");
            System.out.println("| 5 - Trapézio                               |");
            System.out.println("| 0 - Sair                                   |");
            System.out.println("|============================================|");
            System.out.print("| Opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a base do Retângulo: ");
                    double baseRetangulo = scan.nextDouble();
                    System.out.print("Digite a altura do Retângulo: ");
                    double alturaRetangulo = scan.nextDouble();
                    Retangulo retangulo = new Retangulo();
                    retangulo.setBase(baseRetangulo);
                    retangulo.setAltura(alturaRetangulo);
                    formas[contador] = retangulo;
                    contador++;
                    break;

                case 2:
                    System.out.print("Digite o raio do Círculo: ");
                    double raio = scan.nextDouble();
                    Circulo circulo = new Circulo();
                    circulo.setRaio(raio);
                    formas[contador] = circulo;
                    contador++;
                    break;

                case 3:
                    System.out.print("Digite o lado do Quadrado: ");
                    double ladoQuadrado = scan.nextDouble();
                    Quadrado quadrado = new Quadrado();
                    quadrado.setLado(ladoQuadrado);
                    formas[contador] = quadrado;
                    contador++;
                    break;

                case 4:
                    System.out.print("Digite a base do Triângulo: ");
                    double baseTriangulo = scan.nextDouble();
                    System.out.print("Digite a altura do Triângulo: ");
                    double alturaTriangulo = scan.nextDouble();
                    System.out.print("Digite o lado do Triângulo: ");
                    double ladoTriangulo = scan.nextDouble();
                    Triangulo triangulo = new Triangulo();
                    triangulo.setBase(baseTriangulo);
                    triangulo.setAltura(alturaTriangulo);
                    triangulo.setLado(ladoTriangulo);
                    formas[contador] = triangulo;
                    contador++;
                    break;

                case 5:
                    System.out.print("Digite a base maior do Trapézio: ");
                    double baseMaior = scan.nextDouble();
                    System.out.print("Digite a base menor do Trapézio: ");
                    double baseMenor = scan.nextDouble();
                    System.out.print("Digite a altura do Trapézio: ");
                    double alturaTrapezio = scan.nextDouble();
                    System.out.print("Digite o lado 1 do Trapézio: ");
                    double lado1 = scan.nextDouble();
                    System.out.print("Digite o lado 2 do Trapézio: ");
                    double lado2 = scan.nextDouble();
                    Trapezio trapezio = new Trapezio();
                    trapezio.setBaseMaior(baseMaior);
                    trapezio.setBaseMenor(baseMenor);
                    trapezio.setAltura(alturaTrapezio);
                    trapezio.setLado1(lado1);
                    trapezio.setLado2(lado2);
                    formas[contador] = trapezio;
                    contador++;
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0 && contador < 5);

        System.out.println("\nResultados:");

        for (int i = 0; i < contador; i++) {
            FormaGeometrica forma = formas[i];

            if (forma != null) {
                System.out.println("\n" + forma.getClass().getSimpleName());
                System.out.println("Perímetro: " + forma.calcularPerimetro());
                System.out.println("Área: " + forma.calcularArea());
            }
        }
    }
}
