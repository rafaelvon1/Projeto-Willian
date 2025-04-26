package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPopupEmail extends JDialog {
    
    private int codigoDigitado = -1; // Atributo para guardar o código

    private TelaPopupEmail(JFrame parent) {
        super(parent, "Verificar E-mail", true); // true = modal
        setLayout(new BorderLayout());

        JLabel label = new JLabel("e-mail: ");
        JTextField campoCodigo = new JTextField(6);
        JButton botaoVerificar = new JButton("Verificar");

        JPanel painel = new JPanel();
        painel.add(label);
        painel.add(campoCodigo);
        painel.add(botaoVerificar);

        add(painel, BorderLayout.CENTER);

        botaoVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    codigoDigitado = Integer.parseInt(campoCodigo.getText());
                    System.out.println("Dentro do popup: " + codigoDigitado);
                    dispose(); // Fecha o popup
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite apenas números!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSize(300, 120);
        setLocationRelativeTo(parent); // Centraliza
    }

    // Método público estático para abrir o popup e retornar o código digitado
    public static int abrirPopup(JFrame parent) {
        TelaPopupEmail popup = new TelaPopupEmail(parent);
        popup.setVisible(true); // Fica travado até o usuário clicar em "Verificar"
        return popup.codigoDigitado; // Retorna o valor
    }
}
