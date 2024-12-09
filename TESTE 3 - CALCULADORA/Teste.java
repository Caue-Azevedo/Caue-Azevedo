package com.senai.calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Calculadora");
        janela.setBounds(100, 100, 400, 600);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        janela.setLayout(null);

        JTextField display = new JTextField();
        display.setBounds(50, 30, 300, 50);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        janela.add(display);

        String[] botoes = {
                "%", "CE", "C", "<x>",
                "1/x", "x²", "√", "÷",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ",", "="
        };

        // Variáveis para armazenar operandos e operação
        final String[] operacao = {null};
        final double[] primeiroNumero = {0};

        for (int i = 0; i < botoes.length; i++) {
            JButton botao = new JButton(botoes[i]);
            int x = 50 + (i % 4) * 80;
            int y = 100 + (i / 4) * 60;
            botao.setBounds(x, y, 70, 50);

            janela.add(botao);

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String textoBotao = botao.getText();

                    if ("0123456789".contains(textoBotao)) {
                        display.setText(display.getText() + textoBotao);
                    } else if ("C".equals(textoBotao)) {
                        display.setText("");
                        operacao[0] = null;
                        primeiroNumero[0] = 0;
                    } else if ("CE".equals(textoBotao)) {
                        display.setText("");
                    } else if ("<x>".equals(textoBotao)) {
                        String textoAtual = display.getText();
                        if (!textoAtual.isEmpty()) {
                            display.setText(textoAtual.substring(0, textoAtual.length() - 1));
                        }
                    } else if ("+".equals(textoBotao) || "-".equals(textoBotao) || "*".equals(textoBotao) || "÷".equals(textoBotao)) {
                        primeiroNumero[0] = Double.parseDouble(display.getText());
                        operacao[0] = textoBotao;
                        display.setText("");
                    } else if ("=".equals(textoBotao)) {
                        if (operacao[0] != null) {
                            double segundoNumero = Double.parseDouble(display.getText());
                            double resultado = 0;

                            switch (operacao[0]) {
                                case "+":
                                    resultado = primeiroNumero[0] + segundoNumero;
                                    break;
                                case "-":
                                    resultado = primeiroNumero[0] - segundoNumero;
                                    break;
                                case "*":
                                    resultado = primeiroNumero[0] * segundoNumero;
                                    break;
                                case "÷":
                                    if (segundoNumero != 0) {
                                        resultado = primeiroNumero[0] / segundoNumero;
                                    } else {
                                        display.setText("Erro");
                                        return;
                                    }
                                    break;
                            }

                            display.setText(String.valueOf(resultado));
                            operacao[0] = null;
                            primeiroNumero[0] = 0;
                        }
                    }
                }
            });
        }
        janela.setVisible(true);
    }
}
