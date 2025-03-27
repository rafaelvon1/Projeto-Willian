package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.Index;

public class TelaLogin {

    public void TelaLogin() {
        // Criar a janela principal
        JFrame frame = new JFrame("Tela de Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLayout(new GridBagLayout()); // Centraliza tudo na tela
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK); // Fundo preto

        // Criar um painel para envolver os campos (simulando uma "div")
        JPanel painelLogin = new JPanel();
        painelLogin.setLayout(new GridBagLayout());
        painelLogin.setBackground(Color.DARK_GRAY); // Fundo escuro do painel
        painelLogin.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Borda branca

        // Criar os componentes de login
        JLabel labelEmail = new JLabel("Email:");
        JTextField textEmail = new JTextField(20);
        
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField textSenha = new JPasswordField(20);
        
        JButton botaoEnviar = new JButton("Enviar");
        JButton botaoVoltar = new JButton("Voltar");

        // Definir cores dos componentes
        labelEmail.setForeground(Color.WHITE);
        labelSenha.setForeground(Color.WHITE);

        textEmail.setBackground(Color.LIGHT_GRAY);
        textSenha.setBackground(Color.LIGHT_GRAY);

        // Configuração do layout para o painel interno (quadrado)
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento interno
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        painelLogin.add(labelEmail, gbc);
        gbc.gridy++;
        painelLogin.add(textEmail, gbc);
        gbc.gridy++;
        painelLogin.add(labelSenha, gbc);
        gbc.gridy++;
        painelLogin.add(textSenha, gbc);
        gbc.gridy++;
        painelLogin.add(botaoEnviar, gbc);
        gbc.gridy++;
        painelLogin.add(botaoVoltar, gbc);

        // Adicionar o painel no centro da tela
        frame.add(painelLogin);

        // Ação do botão "Enviar"
        botaoEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textEmail.getText();
                char[] senha = textSenha.getPassword();

                

                JOptionPane.showMessageDialog(frame, "Email: " + email + "\nSenha: " + new String(senha));
            }
        });

        // Ação do botão "Voltar"
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a tela de login
                TelaPrincipal telaPrincipal = new TelaPrincipal(); // Voltar para a tela principal
                telaPrincipal.TelaPrincipal();
            }
        });

        // Exibir a janela
        frame.setVisible(true);
    }
}
