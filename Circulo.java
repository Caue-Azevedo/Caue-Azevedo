package com.senai.FormaGeometrica;

public class Circulo {

    float raio;
    float area;
    double pi = 3.14159265;
    float perimetro;


    public void calculoPerimetro(float raio) {
        perimetro = 2 * (float)pi * raio;
    }

    public void calculoArea(float raio) {
        area = raio * raio * (float)pi;
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }
}
