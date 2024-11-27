package com.senai.FormaGeometrica;

public class Trapezio {

    float baseMaior;
    float baseMenor;
    float altura;
    float perimetro;
    float area;
    float lado1;
    float lado2;

   public void calculoArea() {
        area = ((baseMaior + baseMenor) * altura) / 2;
    }


    public void calculoPerimetro(float lado1, float lado2, float baseMaior, float baseMenor) {
        perimetro = baseMaior + baseMenor + lado1 + lado2;
    }

    public float getArea() {
        return area;
    }
    public float getPerimetro() {
        return perimetro;
    }

    public float getBaseMaior() {
        return baseMaior;
    }

    public void setBaseMaior(float baseMaior) {
        this.baseMaior = baseMaior;
    }

    public float getBaseMenor() {
        return baseMenor;
    }

    public void setBaseMenor(float baseMenor) {
        this.baseMenor = baseMenor;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLado1() {
        return lado1;
    }

    public void setLado1(float lado1) {
        this.lado1 = lado1;
    }

    public float getLado2() {
        return lado2;
    }

    public void setLado2(float lado2) {
        this.lado2 = lado2;
    }
}
