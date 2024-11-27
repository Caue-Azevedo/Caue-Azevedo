package com.senai.FormaGeometrica;

public class Trapezio extends FormaGeometrica {
    private double baseMaior;
    private double baseMenor;
    private double altura;
    private double lado1;
    private double lado2;

    public void setBaseMaior(double baseMaior) {
        this.baseMaior = baseMaior;
    }

    public void setBaseMenor(double baseMenor) {
        this.baseMenor = baseMenor;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    @Override
    public double calcularPerimetro() {
        return baseMaior + baseMenor + lado1 + lado2;
    }

    @Override
    public double calcularArea() {
        return (baseMaior + baseMenor) * altura / 2;
    }
}
