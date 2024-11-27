package com.senai.FormaGeometrica;

public class Triangulo extends FormaGeometrica {
    private double base;
    private double altura;
    private double lado;

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return 3 * lado;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
}
