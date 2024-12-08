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

        for (int i = 0; i < 24; i++) {
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
                    } else if ("C".contains(textoBotao) || "CE".contains(textoBotao)) {
                        display.setText("");
                    } else if ("<x>".contains(textoBotao)) {
                        String numeroAtual = display.getText();
                        if (numeroAtual.length() > 0) {
                            display.setText(numeroAtual.substring(0, numeroAtual.length() - 1));
                        }
                    } else if ("+".equals(textoBotao) || "-".equals(textoBotao) || "*".equals(textoBotao) || "/".equals(textoBotao)) {
                        primeiroNumero[0] = Double.parseDouble(display.getText());
                        operacao[0] = textoBotao
                    }
                }
            });
        }
        janela.setVisible(true);
    }
}
