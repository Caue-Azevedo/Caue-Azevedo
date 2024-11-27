package com.senai.FormaGeometrica;

public class Quadrado {
    float lado;
    float perimetro;
    float area;

    public void calculoPerimetro(float lado) {
        perimetro = lado * 4;
    }

    public void calculoArea(float lado) {
        area = lado * lado;
    }

    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }
}
