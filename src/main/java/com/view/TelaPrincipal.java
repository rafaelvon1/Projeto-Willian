package com.view;

import com.Index;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    public void Principal() {
        
        // Configuração da janela
        setTitle("Homepage");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 30, 30)); // Fundo escuro

        // Painel superior (Navbar)
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Alinha os botões à direita
        navBar.setBackground(new Color(20, 20, 20)); // Fundo escuro da navbar
        navBar.setPreferredSize(new Dimension(getWidth(), 60)); // Altura da navbar

        // Botão "Login"
        JButton btnLogin = new JButton("Login");
        estilizarBotao(btnLogin);

        // Botão "Cadastro"
        JButton btnCadastro = new JButton("Cadastro");
        estilizarBotao(btnCadastro);

        // Adiciona botões à navbar
        navBar.add(btnLogin);
        navBar.add(btnCadastro);

        // Painel central
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(30, 30, 30));
        centerPanel.setLayout(new GridBagLayout()); // Centraliza o título

        // Título centralizado
        JLabel titleLabel = new JLabel("Bem-vindo à Aplicação");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        centerPanel.add(titleLabel);

        // Adiciona a navbar e o conteúdo principal
        add(navBar, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        // Ação dos botões
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Index login = new Index();
                login.Login();
                dispose();
            }
        });

        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Index cadastro = new Index();
                cadastro.Cadastro();
                dispose();
            }
        });

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Menu");
        JMenuItem contato = new JMenuItem("Contato");
        JMenuItem sairItem = new JMenuItem("Sair");

        contato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Email: 5mVb9@example.com \nTelefone: (11) 99999-9999 \nEndereço: Rua dos Bobos\n nº 0 - \nSão Paulo/SP - \nCEP: 00000-000");
            }
        });

        sairItem.addActionListener(e -> System.exit(0));
        menuArquivo.add(contato);
        menuArquivo.add(sairItem);
        menuBar.add(menuArquivo);

        setJMenuBar(menuBar);

        setVisible(true);
    }

    // Método para estilizar os botões
    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBackground(new Color(30, 144, 255));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal());
    }
   

}
