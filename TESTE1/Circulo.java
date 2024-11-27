package com.senai.FormaGeometrica;

public class Circulo extends FormaGeometrica {
    private double raio;

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}
