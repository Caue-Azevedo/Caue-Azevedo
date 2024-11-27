package com.senai.FormaGeometrica;

public class Quadrado extends FormaGeometrica {
    private double lado;

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
