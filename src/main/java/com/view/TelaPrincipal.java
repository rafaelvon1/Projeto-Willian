package com.view;
import com.Index;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    public void TelaPrincipal() {
        // Configuração da janela
        setTitle("Home - Minha Aplicação");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(50, 50, 50)); // Cor de fundo escura

        // Título
        JLabel titleLabel = new JLabel("Bem-vindo à Aplicação", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Botão "Entrar"
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setBackground(new Color(30, 144, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton btnEntra = new JButton("Entrar");
        btnEntra.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntra.setBackground(new Color(30, 144, 255));
        btnEntra.setForeground(Color.WHITE);
        btnEntra.setFocusPainted(false);
        btnEntra.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        // Ação do botão
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Index Login = new Index();
                Login.Login();
                dispose();
            }
        });
        btnEntra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou em Entrar!");
            }
        });

        // Painel central
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(50, 50, 50));
        centerPanel.add(btnLogin);
        centerPanel.add(btnEntra);
        panel.add(centerPanel, BorderLayout.CENTER);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Menu");
        JMenuItem contato = new JMenuItem("Contato");
        JMenuItem sairItem = new JMenuItem("Sair");

        menuArquivo.add(contato);
        contato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Email: 5mVb9@example.com \nTelefone: (11) 99999-9999 \nEndereço: Rua dos Bobos,\n nº 0 - São Paulo/SP -\n CEP: 00000-000");
            }
        });


        sairItem.addActionListener(e -> System.exit(0));
        menuArquivo.add(sairItem);
        menuBar.add(menuArquivo);

        setJMenuBar(menuBar);

        // Adiciona o painel à janela
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal());
    }
}

