package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPopupEmail extends JDialog {

    private int codigoDigitado = -1;
    private Timer timer;
    private int tempoRestante = 60;
    private JLabel labelTempo;

    private TelaPopupEmail(JFrame parent) {
        super(parent, "Verificar E-mail", true);

        // Painel principal com padding
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // margem de 20px em todos os lados

        // Painel de entrada (label + campo)
        JPanel painelEntrada = new JPanel(new GridLayout(2, 1, 5, 5));
        JLabel label = new JLabel("Digite o código de verificação:", SwingConstants.CENTER);
        JTextField campoCodigo = new JTextField(10);
        campoCodigo.setHorizontalAlignment(JTextField.CENTER); // Deixa o texto no centro

        painelEntrada.add(label);
        painelEntrada.add(campoCodigo);

        // Painel de botões e tempo
        JPanel painelBotoes = new JPanel(new BorderLayout(5, 5));
        JButton botaoVerificar = new JButton("Verificar");
        labelTempo = new JLabel("Tempo restante: 60 segundos", SwingConstants.CENTER);

        painelBotoes.add(botaoVerificar, BorderLayout.CENTER);
        painelBotoes.add(labelTempo, BorderLayout.SOUTH);

        // Montar o painel principal
        painelPrincipal.add(painelEntrada, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);

        // --- BOTÃO VERIFICAR ---
        botaoVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    codigoDigitado = Integer.parseInt(campoCodigo.getText());
                    System.out.println("Dentro do popup: " + codigoDigitado);
                    timer.stop(); 
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite apenas números!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // --- TIMER PARA CONTAGEM REGRESSIVA ---
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempoRestante--;
                labelTempo.setText("Tempo restante: " + tempoRestante + " segundos");

                if (tempoRestante <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Tempo expirado! O programa será encerrado.", "Tempo Esgotado", JOptionPane.WARNING_MESSAGE);
                    dispose(); // Fecha o popup
                }
            }
        });
        timer.start();

        setSize(350, 250);
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public static int abrirPopup(JFrame parent) {
        TelaPopupEmail popup = new TelaPopupEmail(parent);
        popup.setVisible(true);
        return popup.codigoDigitado;
    }
}
