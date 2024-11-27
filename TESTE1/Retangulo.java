package com.senai.FormaGeometrica;

public class Retangulo {

    float base;
    float altura;
    float perimetro;
    float area;

    public void calculoPerimetro(float base, float altura) {
        perimetro = (base + altura) * 2;
    }

    public void calculoArea(float base, float altura) {
        area = base * altura;
    }

    public float getBase() {
        return base;
    }
    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
}